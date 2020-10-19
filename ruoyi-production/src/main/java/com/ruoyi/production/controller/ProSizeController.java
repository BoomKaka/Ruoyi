package com.ruoyi.production.controller;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.production.domain.ProSpecProperty;
import com.ruoyi.production.service.IProSpecPropertyService;
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
import com.ruoyi.production.domain.ProSize;
import com.ruoyi.production.service.IProSizeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规格Controller
 * 
 * @author SueLiu
 * @date 2020-09-24
 */
@Controller
@RequestMapping("/production/size")
public class ProSizeController extends BaseController
{
    private String prefix = "production/size";

    @Autowired
    private IProSizeService proSizeService;
    @Autowired
    private IProSpecPropertyService proSpecPropertyService;

    @RequiresPermissions("production:size:view")
    @GetMapping()
    public String size()
    {
        return prefix + "/size";
    }

    /**
     * 查询规格列表
     */
    @RequiresPermissions("production:size:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProSize proSize)
    {
        startPage();
        List<ProSize> list = proSizeService.selectProSizeList(proSize);
        return getDataTable(list);
    }

    /**
     * 导出规格列表
     */
    @RequiresPermissions("production:size:export")
    @Log(title = "规格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSize proSize)
    {
        List<ProSize> list = proSizeService.selectProSizeList(proSize);
        ExcelUtil<ProSize> util = new ExcelUtil<ProSize>(ProSize.class);
        return util.exportExcel(list, "size");
    }

    /**
     *  导入产品
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "规格管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:size:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        System.out.println("导入产品数据不能为空！**************1");
        ExcelUtil<ProSize> util = new ExcelUtil<ProSize>(ProSize.class);
        List<ProSize> proSizeList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proSizeService.importSize(proSizeList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:size:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        System.out.println("导入产品数据不能为空！**************2");
        ExcelUtil<ProSize> util = new ExcelUtil<ProSize>(ProSize.class);
        return util.importTemplateExcel("产品数据");
    }

    /**
     * 新增规格
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        return prefix + "/add";
    }

    /**
     * 新增保存规格
     */
    @RequiresPermissions("production:size:add")
    @Log(title = "规格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProSize proSize)
    {
        return toAjax(proSizeService.insertProSize(proSize));
    }

    /**
     * 修改规格
     */
    @GetMapping("/edit/{sizeId}")
    public String edit(@PathVariable("sizeId") Long sizeId, ModelMap mmap)
    {
        ProSize proSize = proSizeService.selectProSizeById(sizeId);
        mmap.put("proSize", proSize);

        ProSpecProperty proSpecProperty = new ProSpecProperty();
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyService.selectProSpecPropertyList(proSpecProperty);
        mmap.addAttribute("proSpecPropertyList",proSpecPropertyList);
        //proSizepropertyList

        return prefix + "/edit";
    }

    /**
     * 修改保存规格
     */
    @RequiresPermissions("production:size:edit")
    @Log(title = "规格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSize proSize)
    {
        return toAjax(proSizeService.updateProSize(proSize));
    }

    /**
     * 删除规格
     */
    @RequiresPermissions("production:size:remove")
    @Log(title = "规格", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proSizeService.deleteProSizeByIds(ids));
    }

    /**
     * 加载规属性树
     */
    @GetMapping("/treeData/{includeId}")
    @ResponseBody
    public List<Ztree> treeDatainclude(@PathVariable(value = "includeId", required = false) Long includeId)
    {
        List<Ztree> ztrees =proSpecPropertyService.selectProSpecPropertyTreeByParentId(includeId);
        return ztrees;
    }

    ///selectSizeSpecProcessor
    /**
     * 选择规格
     */
    @GetMapping("/selectSizeSpecProcessor")
    public String selectSizeSpecProcessor(ModelMap mmap)
    {
        Long includeId = 10L;
        mmap.put("includeId", includeId);
        return prefix + "/tree";
    }

    /**
     * 规格详情
     * @param sizeId
     * @param mmap
     * @return
     */
    @RequiresPermissions("production:size:detail")
    @GetMapping("/detail/{sizeId}")
    public String detail(@PathVariable("sizeId") Long sizeId, ModelMap mmap)
    {
        //System.out.println("size详情界面******");
        mmap.put("proSize", proSizeService.selectProSizeById(sizeId));
        return prefix + "/detail";
    }

}
