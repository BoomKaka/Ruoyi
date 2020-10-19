package com.ruoyi.production.service;

import java.util.List;


import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.domain.ProSize;
/**
 * 产品Service接口
 * 
 * @author Jonie
 * @date 2020-09-21
 */
public interface IProProductionService 
{
    /**
     * 查询产品
     * 
     * @param proId 产品ID
     * @return 产品
     */
    public ProProduction selectProProductionById(Long proId);

    /**
     * 查询产品列表
     * 
     * @param proProduction 产品
     * @return 产品集合
     */
    public List<ProProduction> selectProProductionList(ProProduction proProduction);

    /**
     * 新增产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    public int insertProProduction(ProProduction proProduction);

    /**
     * 修改产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    public int updateProProduction(ProProduction proProduction);

    /**
     * 批量删除产品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProProductionByIds(String ids);

    /**
     * 删除产品信息
     * 
     * @param proId 产品ID
     * @return 结果
     */
    public int deleteProProductionById(Long proId);

    /**
     * 返回产品分类
     * @return
     */
    public List<ProProduction> queryProductionClassList();

    /**
     * 根据分类 返回产品类型列表
     * @param selectedClass
     * @return
     */
    public List<ProProduction> queryProductionTypeList(String selectedClass);

    /**
     * 导入excel数据
     * @param list
     * @param updateSupport
     * @param operName
     * @return
     */
    public String importData(List<ProProduction> list, boolean updateSupport, String operName);

//    /**
//     * 运行公式 更新数据库
//     * @param data
//     * @return
//     */
//    public int execSql(String data);
//
//
//    public int updateInsertByFormula(ProProduction proProduction);
//
    public int updateInsertByFormulaAndOrder(ProProduction proProduction);

    //public ProSize selectProSizeById(Long id);

    public int saveFormula(String data);

    public int execSql(String data);

    //ProSize selectProSizeByBaremodelno(String proProBaremodelno);


    public List<ProProduction> selectProType(String proClass);
}
