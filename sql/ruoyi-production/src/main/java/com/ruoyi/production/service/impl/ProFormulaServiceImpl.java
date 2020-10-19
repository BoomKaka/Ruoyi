package com.ruoyi.production.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.domain.ProFormula ;
import com.ruoyi.production.service.IProFormulaService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.production.mapper.ProFormulaMapper;
/**
 * 公式Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-10
 */
@Service
public class ProFormulaServiceImpl implements IProFormulaService 
{
    @Autowired
    private ProFormulaMapper proFormulaMapper;

    /**
     * 查询公式
     * 
     * @param formId 公式ID
     * @return 公式
     */
    @Override
    public ProFormula selectProFormulaById(Long formId)
    {
        return proFormulaMapper.selectProFormulaById(formId);
    }

    /**
     * 查询公式列表
     * 
     * @param proFormula 公式
     * @return 公式
     */
    @Override
    public List<ProFormula> selectProFormulaList(ProFormula proFormula)
    {
        return proFormulaMapper.selectProFormulaList(proFormula);
    }

    /**
     * 新增公式
     * 
     * @param proFormula 公式
     * @return 结果
     */
    @Override
    public int insertProFormula(ProFormula proFormula)
    {
        return proFormulaMapper.insertProFormula(proFormula);
    }

    /**
     * 修改公式
     * 
     * @param proFormula 公式
     * @return 结果
     */
    @Override
    public int updateProFormula(ProFormula proFormula)
    {
        return proFormulaMapper.updateProFormula(proFormula);
    }

    /**
     * 删除公式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProFormulaByIds(String ids)
    {
        return proFormulaMapper.deleteProFormulaByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公式信息
     * 
     * @param formId 公式ID
     * @return 结果
     */
    @Override
    public int deleteProFormulaById(Long formId)
    {
        return proFormulaMapper.deleteProFormulaById(formId);
    }

    /**
     * 返回公式执行顺序列表
     * @return 结果
     */
    @Override
    public List<ProFormula> selectProFormulaListByOrder()
    {
        return proFormulaMapper.selectProFormulaListByOrder();
    }


}
