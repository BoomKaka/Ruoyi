package com.ruoyi.production.controller;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.production.domain.ProSpecProperty;
import com.ruoyi.production.service.IProSpecPropertyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.web.multipart.MultipartFile;

/**
 * 规格属性Controller
 * 
 * @author Jonie
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/production/spec_property")
public class ProSpecPropertyController extends BaseController
{
    private String prefix = "production/spec_property";

    @Autowired
    private IProSpecPropertyService proSpecPropertyService;

    @RequiresPermissions("production:spec_property:view")
    @GetMapping()
    public String spec_property()
    {
        return prefix + "/spec_property";
    }

    /**
     * 查询规格属性树列表
     */
    @RequiresPermissions("production:spec_property:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ProSpecProperty> list(ProSpecProperty proSpecProperty)
    {
        List<ProSpecProperty> list = proSpecPropertyService.selectProSpecPropertyList(proSpecProperty);
        return list;
    }

    /**
     * 导出规格属性列表
     */
    @RequiresPermissions("production:spec_property:export")
    @Log(title = "规格属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProSpecProperty proSpecProperty)
    {
        List<ProSpecProperty> list = proSpecPropertyService.selectProSpecPropertyList(proSpecProperty);
        ExcelUtil<ProSpecProperty> util = new ExcelUtil<ProSpecProperty>(ProSpecProperty.class);
        return util.exportExcel(list, "spec_property");
    }

    /**
     *  导入产品
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "规格属性管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("production:spec_property:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        //System.out.println("导入产品数据不能为空！**************1");
        ExcelUtil<ProSpecProperty> util = new ExcelUtil<ProSpecProperty>(ProSpecProperty.class);
        List<ProSpecProperty> SpecPropertyList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = proSpecPropertyService.importSpecProperty(SpecPropertyList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("production:spec_property:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        //System.out.println("导入规格属性数据不能为空！**************2");
        ExcelUtil<ProSpecProperty> util = new ExcelUtil<ProSpecProperty>(ProSpecProperty.class);
        return util.importTemplateExcel("规格属性数据");
    }

    /**
     * 新增规格属性
     */
    @GetMapping(value = { "/add/{specpId}", "/add/" })
    public String add(@PathVariable(value = "specpId", required = false) Long specpId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(specpId))
        {
            mmap.put("proSpecProperty", proSpecPropertyService.selectProSpecPropertyById(specpId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存规格属性
     */
    @RequiresPermissions("production:spec_property:add")
    @Log(title = "规格属性", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProSpecProperty proSpecProperty)
    {
        return toAjax(proSpecPropertyService.insertProSpecProperty(proSpecProperty));
    }

    /**
     * 修改规格属性
     */
    @GetMapping("/edit/{specpId}")
    public String edit(@PathVariable("specpId") Long specpId, ModelMap mmap)
    {
        ProSpecProperty proSpecProperty = proSpecPropertyService.selectProSpecPropertyById(specpId);
        mmap.put("proSpecProperty", proSpecProperty);
        return prefix + "/edit";
    }

    /**
     * 修改保存规格属性
     */
    @RequiresPermissions("production:spec_property:edit")
    @Log(title = "规格属性", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProSpecProperty proSpecProperty)
    {
        return toAjax(proSpecPropertyService.updateProSpecProperty(proSpecProperty));
    }

    /**
     * 删除
     */
    @RequiresPermissions("production:spec_property:remove")
    @Log(title = "规格属性", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{specpId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("specpId") Long specpId)
    {
        return toAjax(proSpecPropertyService.deleteProSpecPropertyById(specpId));
    }

    /**
     * 选择规格属性树
     */
    @GetMapping(value = { "/selectSpec_propertyTree/{specpId}", "/selectSpec_propertyTree/" })
    public String selectSpec_propertyTree(@PathVariable(value = "specpId", required = false) Long specpId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(specpId))
        {
            mmap.put("proSpecProperty", proSpecPropertyService.selectProSpecPropertyById(specpId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载规格属性树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = proSpecPropertyService.selectProSpecPropertyTree();
        return ztrees;
    }
}
