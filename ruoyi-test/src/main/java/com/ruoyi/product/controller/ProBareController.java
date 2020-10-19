package com.ruoyi.product.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.product.domain.ProBare;
import com.ruoyi.product.service.IProBareService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 裸机Controller
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
@Controller
@RequestMapping("/product/bare")
public class ProBareController extends BaseController
{
    private String prefix = "product/bare";

    @Autowired
    private IProBareService proBareService;

    @RequiresPermissions("product:bare:view")
    @GetMapping()
    public String bare()
    {
        return prefix + "/bare";
    }

    /**
     * 查询裸机列表
     */
    @RequiresPermissions("product:bare:list")
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
    @RequiresPermissions("product:bare:export")
    @Log(title = "裸机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProBare proBare)
    {
        List<ProBare> list = proBareService.selectProBareList(proBare);
        ExcelUtil<ProBare> util = new ExcelUtil<ProBare>(ProBare.class);
        return util.exportExcel(list, "裸机产品数据");
    }

    /**
     * 导入裸机列表
     */
    @RequiresPermissions("product:bare:import")
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
    @RequiresPermissions("product:bare:view")
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
    @RequiresPermissions("product:bare:add")
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
    @RequiresPermissions("product:bare:edit")
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
    @RequiresPermissions("product:bare:remove")
    @Log(title = "裸机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proBareService.deleteProBareByIds(ids));
    }

    public String detail(@PathVariable("bareId") Integer bareId, ModelMap mmap){
        return "";
    }
}
