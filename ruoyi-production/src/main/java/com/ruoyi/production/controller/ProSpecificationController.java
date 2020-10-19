package com.ruoyi.production.controller;

import java.util.*;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.domain.ProSpecProperty;
import com.ruoyi.production.service.IProSpecPropertyService;
import com.sun.xml.internal.ws.encoding.XMLHTTPBindingCodec;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.production.domain.ProSpecification;
import com.ruoyi.production.service.IProSpecificationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

class subItem {
    private String name;
    private String value;
    public subItem(){
        this.name=null;
        this.value=null;
    }
    public subItem(String name,String value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "subItem{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

/**
 * 规格表Controller
 * 
 * @author SueLiu
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/production/specification")
public class ProSpecificationController extends BaseController
{
    private String prefix = "production/specification";

    @Autowired
    private IProSpecificationService proSpecificationService;
    @Autowired
    private IProSpecPropertyService proSpecPropertyService;

    @RequiresPermissions("production:specification:view")
    @GetMapping()
    public String specification()
    {
        return prefix + "/specification";
    }

    /**
     * 查询规格表列表
     */
    @RequiresPermissions("production:specification:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProSpecification proSpecification)
    {
        startPage();
        List<ProSpecification> list = proSpecificationService.selectProSpecificationList(proSpecification);
        return getDataTable(list);
    }

    /**
     * 导出规格表列表
     */
    @RequiresPermissions("production:specification:export")
    @Log(title = "规格表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSpecification proSpecification)
    {
        List<ProSpecification> list = proSpecificationService.selectProSpecificationList(proSpecification);
        ExcelUtil<ProSpecification> util = new ExcelUtil<ProSpecification>(ProSpecification.class);
        return util.exportExcel(list, "specification");
    }

    /**
     *  导入产品
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "规格管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:specification:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        System.out.println("导入产品数据不能为空！**************1");
        ExcelUtil<ProSpecification> util = new ExcelUtil<ProSpecification>(ProSpecification.class);
        List<ProSpecification> proSpecList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proSpecificationService.importSpecification(proSpecList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:specification:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<ProSpecification> util = new ExcelUtil<ProSpecification>(ProSpecification.class);
        return util.importTemplateExcel("产品数据");
    }

    /**
     * 新增规格表
     */
    @RequestMapping("/add/{proClass}")
    public String add(@PathVariable("proClass") String proClass,ModelMap mmap)
    {
        ProSpecProperty proSpecProperty = new ProSpecProperty();
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyService.selectProSpecPropertyList(proSpecProperty);
        mmap.addAttribute("proSpecPropertyList",proSpecPropertyList);
        if(proClass.equals("CEB"))
        {
            return prefix + "/addCEB";
        }
        else if(proClass.equals("CES"))
        {
            return prefix + "/addCES";
        }
        return null;
    }

    /**
     * 新增保存规格表
     */
    @RequiresPermissions("production:specification:add")
    @Log(title = "规格表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProSpecification proSpecification)
    {
        return toAjax(proSpecificationService.insertProSpecification(proSpecification));
    }

    /**
     * 修改规格表
     */
    @GetMapping("/edit/{specId}")
    public String edit(@PathVariable("specId") Long specId, ModelMap mmap)
    {
        ProSpecProperty proSpecProperty = new ProSpecProperty();
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyService.selectProSpecPropertyList(proSpecProperty);
        mmap.put("proSpecPropertyList",proSpecPropertyList);
        ProSpecification proSpecification = proSpecificationService.selectProSpecificationById(specId);
        mmap.put("proSpecification", proSpecification);
        if(proSpecification.getSpecModelno().startsWith("CEB")){
            return prefix + "/editCEB";
        }else if(proSpecification.getSpecModelno().startsWith("CES")){
            return prefix + "/editCES";
        }else if(proSpecification.getSpecModelno().startsWith("CEP")){
            return prefix + "/editCEP";
        }else if(proSpecification.getSpecModelno().startsWith("CEA")){
            return prefix + "/editCEA";
        }
        return null;
    }

    /**
     * 修改保存规格表
     */
    @RequiresPermissions("production:specification:edit")
    @Log(title = "规格表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSpecification proSpecification)
    {
        return toAjax(proSpecificationService.updateProSpecification(proSpecification));
    }

    /**
     * 删除规格表
     */
    @RequiresPermissions("production:specification:remove")
    @Log(title = "规格表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proSpecificationService.deleteProSpecificationByIds(ids));
    }

    /*
      将字符串数据装换成subItem对象列表
     */
    public List<subItem> stringExchangeToList(String sub){
        String[] strs=sub.split("\\r");
        for (int i = 0; i <strs.length ; i++) {
            System.out.println(strs[i]+"******");
        }
        List<subItem> subItemList = new ArrayList<subItem>();
        int flat=0;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length()>1){
                String[] List = strs[i].split("：");
                if(i >= 1 && List[0].trim().equals(subItemList.get(flat-1).getName().trim())){
                    String str=subItemList.get(flat-1).getValue()+"\n"+List[1].trim();
                    subItemList.get(flat-1).setValue(str);
                }else{
                    subItem subItem = new subItem(List[0].trim(),List[1].trim());
                    subItemList.add(subItem);
                    flat++;
                }
            }
        }
        return subItemList;
    }
    /**
     * 规格详情
     * @param specId
     * @param mmap
     * @return
     */
    @RequiresPermissions("production:specification:detail")
    @GetMapping("/detail/{specId}")
    public String detail(@PathVariable("specId") Long specId, ModelMap mmap)
    {
        //System.out.println("ProSpecification详情界面！！！！########");
        ProSpecification proSpec=proSpecificationService.selectProSpecificationById(specId);
        mmap.put("proSpec",proSpec);
        if(proSpec.getSpecModelno().startsWith("CEB")){
            return prefix + "/detail";
        }else if(proSpec.getSpecModelno().startsWith("CES")){
            List<subItem> systemList=stringExchangeToList(proSpec.getSpecSpecSystem());
            mmap.put("systemList",systemList);
            List<subItem> externalList=stringExchangeToList(proSpec.getSpecSpecExternalio());
            mmap.put("externalList",externalList);
            List<subItem> internalList=stringExchangeToList(proSpec.getSpecSpecInternalio());
            mmap.put("internalList",internalList);
            List<subItem> powerList=stringExchangeToList(proSpec.getSpecSpecPower());
            mmap.put("powerList",powerList);
            List<subItem> environmentalList=stringExchangeToList(proSpec.getSpecSpecEnvironment());
            mmap.put("environmentalList",environmentalList);
            List<subItem> mechanicalList=stringExchangeToList(proSpec.getSpecSpecMechanical());
            mmap.put("mechanicalList",mechanicalList);
            return prefix + "/detailCES";
        }else if(proSpec.getSpecModelno().startsWith("CSP")){
            List<subItem> systemList=stringExchangeToList(proSpec.getSpecSpecSystem());
            mmap.put("systemList",systemList);
            List<subItem> touchList=stringExchangeToList(proSpec.getSpecSpecTouchscreen());
            mmap.put("touchList",touchList);
            List<subItem> displayList=stringExchangeToList(proSpec.getSpecSpecDisplay());
            mmap.put("displayList",displayList);
            List<subItem> externalList=stringExchangeToList(proSpec.getSpecSpecExternalio());
            mmap.put("externalList",externalList);
            List<subItem> internalList=stringExchangeToList(proSpec.getSpecSpecInternalio());
            mmap.put("internalList",internalList);
            List<subItem> powerList=stringExchangeToList(proSpec.getSpecSpecPower());
            mmap.put("powerList",powerList);
            List<subItem> environmentalList=stringExchangeToList(proSpec.getSpecSpecEnvironment());
            mmap.put("environmentalList",environmentalList);
            List<subItem> mechanicalList=stringExchangeToList(proSpec.getSpecSpecMechanical());
            mmap.put("mechanicalList",mechanicalList);
            return prefix + "/detailCEP";
        }else if(proSpec.getSpecModelno().startsWith("CSA")){
            List<subItem> ceaList=stringExchangeToList(proSpec.getSpecSpecCea());
            mmap.put("ceaList",ceaList);
            return prefix + "/detailCEA";
        }
        return prefix + "/detail";
    }

    /**
     * 通过外部接口查询具体信息值
     * @param request
     * @return
     */
    @RequiresPermissions("production:specification:detail")
    @PostMapping("/selectSpecInterfaceByParentId")
    @ResponseBody
    public List<ProSpecProperty> selectSpecInterfaceByParentId(HttpServletRequest request)
    {
        String id=request.getParameter("parent_id");
        long parent_id=Long.parseLong(id);
        //通过获取的id值，查询以当前id为父id的name
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyService.selectSpecInterfaceNameByParentId(parent_id);
        return proSpecPropertyList;
    }
}
