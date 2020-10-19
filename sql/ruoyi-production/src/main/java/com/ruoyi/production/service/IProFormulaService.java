package com.ruoyi.production.service;

import java.util.List;
import com.ruoyi.production.domain.ProFormula ;

/**
 * 公式Service接口
 * 
 * @author ruoyi
 * @date 2020-10-10
 */
public interface IProFormulaService 
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
     * 批量删除公式
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFormulaByIds(String ids);

    /**
     * 删除公式信息
     * 
     * @param formId 公式ID
     * @return 结果
     */
    public int deleteProFormulaById(Long formId);

    public List<ProFormula> selectProFormulaListByOrder();
}
