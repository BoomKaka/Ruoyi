package com.ruoyi.production.controller;

import java.util.List;

import com.ruoyi.production.service.IProProductionService;
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
import com.ruoyi.production.domain.ProFormula;
import com.ruoyi.production.service.IProFormulaService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 公式Controller
 * 
 * @author ruoyi
 * @date 2020-10-10
 */
@Controller
@RequestMapping("/production/formula")
public class ProFormulaController extends BaseController
{
    private String prefix = "production/formula";

    @Autowired
    private IProFormulaService proFormulaService;
    @Autowired
    public IProProductionService proProductionService;

    @RequiresPermissions("production:formula:view")
    @GetMapping()
    public String formula()
    {
        return prefix + "/formula";
    }

    /**
     * 查询公式列表
     */
    @RequiresPermissions("production:formula:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProFormula proFormula)
    {
        startPage();
        List<ProFormula> list = proFormulaService.selectProFormulaList(proFormula);
        return getDataTable(list);
    }

    /**
     * 导出公式列表
     */
    @RequiresPermissions("production:formula:export")
    @Log(title = "公式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProFormula proFormula)
    {
        List<ProFormula> list = proFormulaService.selectProFormulaList(proFormula);
        ExcelUtil<ProFormula> util = new ExcelUtil<ProFormula>(ProFormula.class);
        return util.exportExcel(list, "formula");
    }

    @RequiresPermissions("production:formula:execFormula")
    @PostMapping("/execFormula")
    @ResponseBody
    public int execFormula(HttpServletRequest request){

        String data = request.getParameter("exec");

        List<ProFormula> proFormulaList1 = proFormulaService.selectProFormulaListByOrder();
        int res = 0;
        for(int i = 0;i < proFormulaList1.size();i++){
            ProFormula proFormula = (ProFormula)proFormulaList1.get(i);
            res = proProductionService.execSql(proFormula.getFormProterty() + "=" + proFormula.getFormContent());
        }

        return res;
    }
    /**
     * 新增公式
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公式
     */
    @RequiresPermissions("production:formula:add")
    @Log(title = "公式", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProFormula proFormula)
    {
        return toAjax(proFormulaService.insertProFormula(proFormula));
    }

    /**
     * 修改公式
     */
    @GetMapping("/edit/{formId}")
    public String edit(@PathVariable("formId") Long formId, ModelMap mmap)
    {
        ProFormula proFormula = proFormulaService.selectProFormulaById(formId);
        mmap.put("proFormula", proFormula);
        return prefix + "/edit";
    }

    /**
     * 修改保存公式
     */
    @RequiresPermissions("production:formula:edit")
    @Log(title = "公式", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProFormula proFormula)
    {
        return toAjax(proFormulaService.updateProFormula(proFormula));
    }

    /**
     * 删除公式
     */
    @RequiresPermissions("production:formula:remove")
    @Log(title = "公式", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proFormulaService.deleteProFormulaByIds(ids));
    }

    @RequiresPermissions("production:formula:queryExchangeAndTax")
    @PostMapping("/queryExchangeAndTax")
    @ResponseBody
    public List<ProFormula> queryExchangeAndTax(HttpServletRequest request){
        ProFormula proFormula = new ProFormula();

        List<ProFormula> proFormulaList = proFormulaService.selectProFormulaList(proFormula);

        return proFormulaList;
    }
}
