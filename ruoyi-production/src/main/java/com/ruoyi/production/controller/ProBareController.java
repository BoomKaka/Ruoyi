package com.ruoyi.production.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.production.domain.ProBare;
import com.ruoyi.production.service.IProBareService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * 裸机Controller
 * 
 * @author Jonie
 * @date 2020-09-14
 */
@Controller
@RequestMapping("/production/bare")
public class ProBareController extends BaseController
{
    private String prefix = "production/bare";

    @Autowired
    private IProBareService proBareService;

    /**
     * bare_type 类型不重复查询
     * @param model
     * @return
     */
    @RequiresPermissions("production:bare:view")
    @GetMapping()
    public String bare(Model model)
    {
        List<ProBare> list=proBareService.queryProBareTypeList();
        model.addAttribute("bareTypeList",list);
        return prefix + "/bare";
    }

    /**
     * 查询裸机列表
     */
    @RequiresPermissions("production:bare:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProBare proBare)
    {
        startPage();
        List<ProBare> list = proBareService.selectProBareList(proBare);
        return getDataTable(list);
    }

    /**
     * 导出裸机列表
     */
    @RequiresPermissions("production:bare:export")
    @Log(title = "裸机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProBare proBare)
    {
        List<ProBare> list = proBareService.selectProBareList(proBare);
        ExcelUtil<ProBare> util = new ExcelUtil<ProBare>(ProBare.class);
        return util.exportExcel(list, "bare");
    }
    /**
     * 导入裸机列表
     */
    @RequiresPermissions("production:bare:import")
    @Log(title = "裸机",businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ProBare> util = new ExcelUtil<ProBare>(ProBare.class);
        List<ProBare> bareList = util.importExcel(file.getInputStream());
        String message = proBareService.importBare(bareList,updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 下载模板
     */
    @RequiresPermissions("production:bare:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate(){
        ExcelUtil<ProBare> util = new ExcelUtil<ProBare>(ProBare.class);
        return util.importTemplateExcel("裸机产品数据");
    }

    /**
     * 新增裸机
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存裸机
     */
    @RequiresPermissions("production:bare:add")
    @Log(title = "裸机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProBare proBare)
    {
        return toAjax(proBareService.insertProBare(proBare));
    }

    /**
     * 修改裸机
     */
    @GetMapping("/edit/{bareId}")
    public String edit(@PathVariable("bareId") Integer bareId, ModelMap mmap)
    {
        ProBare proBare = proBareService.selectProBareById(bareId);
        mmap.put("proBare", proBare);
        return prefix + "/edit";
    }

    /**
     * 修改保存裸机
     */
    @RequiresPermissions("production:bare:edit")
    @Log(title = "裸机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProBare proBare)
    {
        return toAjax(proBareService.updateProBare(proBare));
    }

    /**
     * 删除裸机
     */
    @RequiresPermissions("production:bare:remove")
    @Log(title = "裸机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proBareService.deleteProBareByIds(ids));
    }
}
