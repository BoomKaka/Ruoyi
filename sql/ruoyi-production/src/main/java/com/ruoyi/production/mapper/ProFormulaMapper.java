package com.ruoyi.production.mapper;

import java.util.List;

import com.ruoyi.production.domain.ProFormula;

/**
 * 公式Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-10
 */
public interface ProFormulaMapper 
{
    /**
     * 查询公式
     * 
     * @param formId 公式ID
     * @return 公式
     */
    public ProFormula selectProFormulaById(Long formId);

    /**
     * 查询公式列表
     * 
     * @param proFormula 公式
     * @return 公式集合
     */
    public List<ProFormula> selectProFormulaList(ProFormula proFormula);

    /**
     * 新增公式
     * 
     * @param proFormula 公式
     * @return 结果
     */
    public int insertProFormula(ProFormula proFormula);

    /**
     * 修改公式
     * 
     * @param proFormula 公式
     * @return 结果
     */
    public int updateProFormula(ProFormula proFormula);

    /**
     * 删除公式
     * 
     * @param formId 公式ID
     * @return 结果
     */
    public int deleteProFormulaById(Long formId);

    /**
     * 批量删除公式
     * 
     * @param formIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFormulaByIds(String[] formIds);


    /**
     * 返回公式顺序执行LIST
     * @param proFormula
     * @return
     */
    public List<ProFormula> selectProFormulaListByOrder();
}
