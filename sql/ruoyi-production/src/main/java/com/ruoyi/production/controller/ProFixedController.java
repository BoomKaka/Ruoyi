package com.ruoyi.production.controller;

import java.sql.SQLOutput;
import java.util.List;
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
import com.ruoyi.production.domain.ProFixed;
import com.ruoyi.production.service.IProFixedService;
import com.ruoyi.generator.domain.GenTableColumn;
import com.ruoyi.generator.service.IGenTableColumnService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公式Controller
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Controller
@RequestMapping("/production/fixed")
public class ProFixedController extends BaseController
{
    private String prefix = "production/fixed";

    @Autowired
    private IProFixedService proFixedService;

    @Autowired
    private IGenTableColumnService genTableColumnService;

    @RequiresPermissions("production:fixed:view")
    @GetMapping()
    public String fixed()
    {
        System.out.println("进入公式界面！");
        return prefix + "/fixed";
    }

    /**
     * 查询公式列表
     */
    @RequiresPermissions("production:fixed:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProFixed proFixed)
    {
        startPage();
        List<ProFixed> list = proFixedService.selectProFixedList(proFixed);
        return getDataTable(list);
    }

    /**
     * 导出公式列表
     */
    @RequiresPermissions("production:fixed:export")
    @Log(title = "公式", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProFixed proFixed)
    {
        List<ProFixed> list = proFixedService.selectProFixedList(proFixed);
        ExcelUtil<ProFixed> util = new ExcelUtil<ProFixed>(ProFixed.class);
        return util.exportExcel(list, "fixed");
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
    @RequiresPermissions("production:fixed:add")
    @Log(title = "公式", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProFixed proFixed)
    {
        return toAjax(proFixedService.insertProFixed(proFixed));
    }

    /**
     * 修改公式
     */
    @GetMapping("/edit/{fixedId}")
    public String edit(@PathVariable("fixedId") Long fixedId, ModelMap mmap)
    {
        ProFixed proFixed = proFixedService.selectProFixedById(fixedId);
        System.out.println("修改公式！");
        mmap.put("proFixed", proFixed);
        return prefix + "/edit";
    }

    /**
     * 查询各个表的列字段 在编辑公式和添加公式页
     * @param
     * @return
     */
    @RequiresPermissions("production:fixed:list")
    @PostMapping("/column/list1")
    @ResponseBody
    public TableDataInfo columeList1(){
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectDbTableColumnsByName("pro_bare");   //.selectGenTableColumnListByTableId(genTableColumn);
        for(int i=list.size()-1;i>=1; i--){
            System.out.println(list.get(i).getColumnType());
            if (list.get(i).getColumnType().startsWith("varchar") ||list.get(i).getColumnType().startsWith("date")){
                list.remove(i);
            }
        }
        list.remove(0);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return getDataTable(list);
    }
    @RequiresPermissions("production:fixed:list")
    @PostMapping("/column/list2")
    @ResponseBody
    public TableDataInfo columeList2(){
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectDbTableColumnsByName("pro_complete");   //.selectGenTableColumnListByTableId(genTableColumn);
        for(int i=list.size()-1;i>=1; i--){
            System.out.println(list.get(i).getColumnType());
            if (list.get(i).getColumnType().startsWith("varchar") ||list.get(i).getColumnType().startsWith("date")){
                list.remove(i);
            }
        }
        list.remove(0);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return getDataTable(list);
    }
    @RequiresPermissions("production:fixed:list")
    @PostMapping("/column/list3")
    @ResponseBody
    public TableDataInfo columeList3(){
        TableDataInfo dataInfo = new TableDataInfo();
        List<GenTableColumn> list = genTableColumnService.selectDbTableColumnsByName("pro_fittings");   //.selectGenTableColumnListByTableId(genTableColumn);
        for(int i=list.size()-1;i>=1; i--){
            System.out.println(list.get(i).getColumnType());
            if (list.get(i).getColumnType().startsWith("varchar") ||list.get(i).getColumnType().startsWith("date")){
                list.remove(i);
            }
        }
        list.remove(0);
        dataInfo.setRows(list);
        dataInfo.setTotal(list.size());
        return getDataTable(list);
    }

    /**
     * 修改保存公式
     */
    @RequiresPermissions("production:fixed:edit")
    @Log(title = "公式", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProFixed proFixed)
    {
        return toAjax(proFixedService.updateProFixed(proFixed));
    }

    /**
     * 删除公式
     */
    @RequiresPermissions("production:fixed:remove")
    @Log(title = "公式", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(proFixedService.deleteProFixedByIds(ids));
    }
}
