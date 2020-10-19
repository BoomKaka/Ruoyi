package com.ruoyi.production.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.mapper.ProFittingsMapper;
import com.ruoyi.production.service.impl.ProFittingsServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ruoyi.production.domain.ProFittings;
import com.ruoyi.production.service.IProFittingsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 配件Controller
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
@Controller
@RequestMapping("/production/fittings")
public class ProFittingsController extends BaseController
{
    private String prefix = "production/fittings";

    @Autowired
    private IProFittingsService proFittingsService;

    @RequiresPermissions("production:fittings:view")
    @GetMapping()
    public String fittings(Model model)
    {
        List<ProFittings> MainClassList = proFittingsService.selectfitMainclass();//查询
        model.addAttribute("MainClassList",MainClassList);
        System.out.println("进入配件界面！");
        return prefix + "/fittings";
    }

    @RequiresPermissions("production:fittings:selectfitFuclass")
    @PostMapping("/selectfitFuclass")
    @ResponseBody
    public List<ProFittings> fitFuclass(HttpServletRequest request){
        String fitFuclass = request.getParameter("fitMainclass");
        List<ProFittings> fitFuclassList = proFittingsService.selectfitFuclass(fitFuclass);
        HashSet<String> set  = new HashSet<String>();
        for(int i = 0; i < fitFuclassList.size(); i++){
            ProFittings proFittings = (ProFittings)fitFuclassList.get(i);
            set.add(proFittings.getFitFuclass());
        }
        List<ProFittings> proList1  = new ArrayList<ProFittings>();

        for(int i = 0; i < fitFuclassList.size(); i++){
            ProFittings proFittings = (ProFittings)fitFuclassList.get(i);
            if(set.contains(proFittings.getFitFuclass())){
                proList1.add(proFittings);
                set.remove(proFittings.getFitFuclass());
            }
        }

        return proList1;
    }


    /**
     * 查询配件列表
     */
    @RequiresPermissions("production:fittings:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProFittings proFittings)
    {
        startPage();
        List<ProFittings> list = proFittingsService.selectProFittingsList(proFittings);
        return getDataTable(list);
    }

    //    导入配件
    @Log(title = "配件管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:fittings:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProFittings> util = new ExcelUtil<ProFittings>(ProFittings.class);
        List<ProFittings> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proFittingsService.importFittings(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:fittings:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<ProFittings> util = new ExcelUtil<ProFittings>(ProFittings.class);
        return util.importTemplateExcel("配件数据");
    }
    /**
     * 导出配件列表
     */
    @RequiresPermissions("production:fittings:export")
    @Log(title = "配件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProFittings proFittings)
    {
        List<ProFittings> list = proFittingsService.selectProFittingsList(proFittings);
        ExcelUtil<ProFittings> util = new ExcelUtil<ProFittings>(ProFittings.class);
        return util.exportExcel(list, "fittings");
    }

    /**
     * 新增配件
     */
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 新增保存配件
     */
    @RequiresPermissions("production:fittings:add")
    @Log(title = "配件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProFittings proFittings)
    {
        return toAjax(proFittingsService.insertProFittings(proFittings));
    }

    /**
     * 修改配件
     */
    @GetMapping("/edit/{fittingsId}")
    public String edit(@PathVariable("fittingsId") Integer fittingsId, ModelMap mmap)
    {
        ProFittings proFittings = proFittingsService.selectProFittingsById(fittingsId);
        mmap.put("proFittings", proFittings);
        return prefix + "/edit";
    }

    /**
     * 修改保存配件
     */
    @RequiresPermissions("production:fittings:edit")
    @Log(title = "配件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProFittings proFittings)
    {
        return toAjax(proFittingsService.updateProFittings(proFittings));
    }

    /**
     * 删除配件
     */
    @RequiresPermissions("production:fittings:remove")
    @Log(title = "配件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proFittingsService.deleteProFittingsByIds(ids));
    }
}
