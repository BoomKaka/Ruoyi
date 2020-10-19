package com.ruoyi.production.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProFixedMapper;
import com.ruoyi.production.domain.ProFixed;
import com.ruoyi.production.service.IProFixedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 公式Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
@Service
public class ProFixedServiceImpl implements IProFixedService 
{
    @Autowired
    private ProFixedMapper proFixedMapper;

    /**
     * 查询公式
     * 
     * @param fixedId 公式ID
     * @return 公式
     */
    @Override
    public ProFixed selectProFixedById(Long fixedId)
    {
        return proFixedMapper.selectProFixedById(fixedId);
    }

    /**
     * 查询公式列表
     * 
     * @param proFixed 公式
     * @return 公式
     */
    @Override
    public List<ProFixed> selectProFixedList(ProFixed proFixed)
    {
        return proFixedMapper.selectProFixedList(proFixed);
    }

    /**
     * 新增公式
     * 
     * @param proFixed 公式
     * @return 结果
     */
    @Override
    public int insertProFixed(ProFixed proFixed)
    {
        return proFixedMapper.insertProFixed(proFixed);
    }

    /**
     * 修改公式
     * 
     * @param proFixed 公式
     * @return 结果
     */
    @Override
    public int updateProFixed(ProFixed proFixed)
    {
        return proFixedMapper.updateProFixed(proFixed);
    }

    /**
     * 删除公式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProFixedByIds(String ids)
    {
        return proFixedMapper.deleteProFixedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除公式信息
     * 
     * @param fixedId 公式ID
     * @return 结果
     */
    @Override
    public int deleteProFixedById(Long fixedId)
    {
        return proFixedMapper.deleteProFixedById(fixedId);
    }
}
