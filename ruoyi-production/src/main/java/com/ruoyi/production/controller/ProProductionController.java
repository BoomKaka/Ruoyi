package com.ruoyi.production.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.domain.ProFormula;
import com.ruoyi.production.domain.ProSize;
import com.ruoyi.production.service.IProSizeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.service.IProProductionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.production.service.IProFormulaService;
import javax.servlet.http.HttpServletRequest;

/**
 * 产品Controller
 * 
 * @author Jonie
 * @date 2020-09-21
 */
@Controller
@RequestMapping("/production/production")
public class ProProductionController extends BaseController
{
    private String prefix = "production/production";

    @Autowired
    private IProProductionService proProductionService;
    @Autowired
    public IProSizeService proSizeService;
    @Autowired
    public IProFormulaService proFormulaService;


    @RequiresPermissions("production:production:view")
    @GetMapping()
    public String production(Model model)
    {
        List<ProProduction> proProductionClassList = proProductionService.queryProductionClassList();
        model.addAttribute("proProductionClassList",proProductionClassList);
        return prefix + "/production";
    }

    /**
     * 根据分类 返回类型列表
     * @param request
     * @return
     */
    @RequiresPermissions("production:production:queryTypeList")
    @PostMapping("/queryTypeList")
    @ResponseBody
    public List<ProProduction> queryTypeList(HttpServletRequest request){
        String compClass = request.getParameter("selectedClass");
        List<ProProduction> proProductionTypeList = proProductionService.queryProductionTypeList(compClass);
        HashSet<String> set  = new HashSet<String>();
        for(int i = 0;i < proProductionTypeList.size();i++){
            ProProduction proProduction = (ProProduction) proProductionTypeList.get(i);
            set.add(proProduction.getProType());
        }
        List<ProProduction> proProductionTypeList1 = new ArrayList<ProProduction>();

        for(int i = 0;i < proProductionTypeList.size();i++){
            ProProduction proProduction = (ProProduction)proProductionTypeList.get(i);
            if(set.contains(proProduction.getProType())){
                proProductionTypeList1.add(proProduction);
                set.remove(proProduction.getProType());
            }
        }

        return proProductionTypeList1;
    }

    @RequiresPermissions("production:production:queryExchangeAndTax")
    @PostMapping("/queryExchangeAndTax")
    @ResponseBody
    public List<ProFormula> queryExchangeAndTax(HttpServletRequest request){
        ProFormula proFormula = new ProFormula();

        List<ProFormula> proFormulaList = proFormulaService.selectProFormulaList(proFormula);

        return proFormulaList;
    }
    /**
     * 执行公式 并且保存到公式表中
     * @param request
     * @return
     */
    @RequiresPermissions("production:production:execSql")
    @PostMapping("/execSql")
    @ResponseBody
    public int execSql(HttpServletRequest request){

        String data = request.getParameter("Sql");
        int res = proProductionService.saveFormula(data);
        int res1 = proProductionService.execSql(data);
        return res;
    }

    @RequiresPermissions("production:production:saveFormula")
    @PostMapping("/saveFormula")
    @ResponseBody
    public int saveFormula(HttpServletRequest request){
        String data = request.getParameter("Sql");
        int res = proProductionService.saveFormula(data);

        return res;
    }

    /**
     * 导出 导入数据模板
     * @return
     */
    @RequiresPermissions("production:production:importTemplate")
    @GetMapping("importTemplate")
    @ResponseBody
    public AjaxResult importTemplate(){
        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        return util.importTemplateExcel("产品数据");
    }

    /**
     * 导入数据
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "产品管理",businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:production:import")
    @PostMapping("importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        List<ProProduction> proProductionList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proProductionService.importData(proProductionList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    /**
     * 查询产品列表
     */
    @RequiresPermissions("production:production:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProProduction proProduction)
    {
        startPage();
        List<ProProduction> list = proProductionService.selectProProductionList(proProduction);

        Subject currentUser = SecurityUtils.getSubject();
        boolean permitted = currentUser.isPermitted("production:production:edit");

        if(permitted){
            String a = "heelo";
        }else{
            for(int i = 0;i < list.size();i++){
                BigDecimal bigDecimal = new BigDecimal("0");
                ProProduction proProduction1 = list.get(i);
                proProduction1.setProProPrice1(bigDecimal);
                proProduction1.setProProPrice2(bigDecimal);
                proProduction1.setProProPrice3(bigDecimal);
                proProduction1.setProProPrice4(bigDecimal);
                proProduction1.setProCost(bigDecimal);
                proProduction1.setProCostIncludetax(bigDecimal);
                proProduction1.setProFitCosttax(bigDecimal);
                proProduction1.setProFitFanprice(bigDecimal);
                proProduction1.setProFitFancost(bigDecimal);
                proProduction1.setProProGp1(Long.valueOf(0));
                proProduction1.setProProGp2(Long.valueOf(0));
                proProduction1.setProProGp3(Long.valueOf(0));
                proProduction1.setProProGp4(Long.valueOf(0));
                proProduction1.setProFitFanprice(bigDecimal);
                proProduction1.setProFitFanprice1(bigDecimal);
                proProduction1.setProFitPrice(bigDecimal);
                proProduction1.setProFitGp(bigDecimal);
                proProduction1.setProReverse(bigDecimal);
                proProduction1.setProFitFangp(Long.valueOf(0));
                proProduction1.setProFitManufacturntax(Long.valueOf(0));
                proProduction1.setProFitPriceincludetax(bigDecimal);
                proProduction1.setProFitNomove(Long.valueOf(0));
            }
        }
        return getDataTable(list);
    }
    /**
     * 导出产品列表
     */
    @RequiresPermissions("production:production:export")
    @Log(title = "产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProProduction proProduction)
    {
        List<ProProduction> list = proProductionService.selectProProductionList(proProduction);
        Subject currentUser = SecurityUtils.getSubject();
        boolean permitted = currentUser.isPermitted("production:production:edit");

        if(permitted){
            String a = "heelo";
        }else{
            for(int i = 0;i < list.size();i++){
                BigDecimal bigDecimal = new BigDecimal("0");
                ProProduction proProduction1 = list.get(i);
                proProduction1.setProProPrice1(bigDecimal);
                proProduction1.setProProPrice2(bigDecimal);
                proProduction1.setProProPrice3(bigDecimal);
                proProduction1.setProProPrice4(bigDecimal);
                proProduction1.setProCost(bigDecimal);
                proProduction1.setProCostIncludetax(bigDecimal);
                proProduction1.setProFitCosttax(bigDecimal);
                proProduction1.setProFitFanprice(bigDecimal);
                proProduction1.setProFitFancost(bigDecimal);
                proProduction1.setProProGp1(Long.valueOf(0));
                proProduction1.setProProGp2(Long.valueOf(0));
                proProduction1.setProProGp3(Long.valueOf(0));
                proProduction1.setProProGp4(Long.valueOf(0));
                proProduction1.setProFitFanprice(bigDecimal);
                proProduction1.setProFitFanprice1(bigDecimal);
                proProduction1.setProFitPrice(bigDecimal);
                proProduction1.setProFitGp(bigDecimal);
                proProduction1.setProReverse(bigDecimal);
                proProduction1.setProFitFangp(Long.valueOf(0));
                proProduction1.setProFitManufacturntax(Long.valueOf(0));
                proProduction1.setProFitPriceincludetax(bigDecimal);
                proProduction1.setProFitNomove(Long.valueOf(0));
            }
        }

        ExcelUtil<ProProduction> util = new ExcelUtil<ProProduction>(ProProduction.class);
        return util.exportExcel(list, "production");
    }

    /**
     * 新增产品
     */
    @GetMapping("/add")
    public String add(Model model)
    {
        List<ProProduction> proProductionClassList = proProductionService.queryProductionClassList();
        model.addAttribute("proProductionClassList",proProductionClassList);
        return prefix + "/add";
    }

    /**
     * 新增保存产品
     */
    @RequiresPermissions("production:production:add")
    @Log(title = "产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProProduction proProduction)
    {

        int res = proProductionService.insertProProduction(proProduction);

        AjaxResult ajaxResult = toAjax(res);

        List<ProFormula> proFormulaList = proFormulaService.selectProFormulaListByOrder();

        for(int i = 0;i < proFormulaList.size();i++){
            ProFormula proFormula = (ProFormula)proFormulaList.get(i);
            res = proProductionService.execSql(proFormula.getFormProterty() + "=" + proFormula.getFormContent());
        }

        return ajaxResult;
    }

    /**
     * 修改产品
     */
    @GetMapping("/edit/{proId}")
    public String edit(@PathVariable("proId") Long proId, ModelMap mmap,Model model)
    {
        ProProduction proProduction = proProductionService.selectProProductionById(proId);
        mmap.put("proProduction", proProduction);
        List<ProProduction> proProductionClassList = proProductionService.queryProductionClassList();
        model.addAttribute("proProductionClassList",proProductionClassList);


        return prefix + "/edit";
    }

    /**
     * 查看详细
     */
//    @GetMapping("/detail/{proId}")
//    public String detail(@PathVariable("proId") Long proId, ModelMap mmap)
//    {
//
//        ProProduction proProduction = proProductionService.selectProProductionById(proId);
//        String proProBaremodelno = proProduction.getProProBaremodelno();
//
//
//        String a = proProBaremodelno.substring(0,5);
//        String b = proProBaremodelno.substring(8);
//        String s = a + "%" + b;
//        ProSize proSize = proProductionService.selectProSizeByBaremodelno(s);
//
//        mmap.put("proSize", proSize);
//        return prefix + "/detail";
//    }




    /**
     * 修改保存产品
     */
    @RequiresPermissions("production:production:edit")
    @Log(title = "产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProProduction proProduction)
    {
        return toAjax(proProductionService.updateProProduction(proProduction));
    }

    /**
     * 删除产品
     */
    @RequiresPermissions("production:production:remove")
    @Log(title = "产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proProductionService.deleteProProductionByIds(ids));
    }


    /**
     * 根据分类查询类型（不重复）
     * @param request
     * @return
     */
    @RequiresPermissions("production:production:selectProType")
    @PostMapping("/selectProType")
    @ResponseBody
    public List<ProProduction> selectProType(HttpServletRequest request)
    {
        String proClass=request.getParameter("ProClassData");
        List<ProProduction> proTypeList = proProductionService.selectProType(proClass);
        return proTypeList;
    }

}
