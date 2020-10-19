package com.ruoyi.production.mapper;

import java.util.List;

import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.domain.ProSize;
import org.apache.ibatis.annotations.Param;

/**
 * 产品Mapper接口
 * 
 * @author Jonie
 * @date 2020-09-21
 */
public interface ProProductionMapper 
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
     * 删除产品
     * 
     * @param proId 产品ID
     * @return 结果
     */
    public int deleteProProductionById(Long proId);

    /**
     * 批量删除产品
     * 
     * @param proIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProProductionByIds(String[] proIds);

    /**
     * 返回产品分类
     * @return List
     */
    public List<ProProduction> queryProductionClassList();

    /**
     * 根据产品分类 返回产品类型列表
     * @param selectedClass
     * @return
     */
    public List<ProProduction> queryProductionTypeList(String selectedClass);

    /**
     * 运行公式
     * @param data
     * @return
     */
    public int execSql(@Param("data") String data);

    /**
     * 保存公式
     */
    public int saveMath(@Param("needSave") String needSave);

    public int updateInsertByFormula(@Param("math8") String math8);


//    public ProFormula selectProFormulaById(Long id);

//    public ProSize selectProSizeById(Long id);
//
//    ProSize selectProSizeByBaremodelno(String proProBaremodelno);

    public int saveFormula(@Param("sqlInsert") String sqlInsert);

    public List<ProProduction> selectProType(String proClass);

}
