package com.ruoyi.production.service;

import java.util.List;
import com.ruoyi.production.domain.ProFixed;

/**
 * 公式Service接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface IProFixedService 
{
    /**
     * 查询公式
     * 
     * @param fixedId 公式ID
     * @return 公式
     */
    public ProFixed selectProFixedById(Long fixedId);

    /**
     * 查询公式列表
     * 
     * @param proFixed 公式
     * @return 公式集合
     */
    public List<ProFixed> selectProFixedList(ProFixed proFixed);

    /**
     * 新增公式
     * 
     * @param proFixed 公式
     * @return 结果
     */
    public int insertProFixed(ProFixed proFixed);

    /**
     * 修改公式
     * 
     * @param proFixed 公式
     * @return 结果
     */
    public int updateProFixed(ProFixed proFixed);

    /**
     * 批量删除公式
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFixedByIds(String ids);

    /**
     * 删除公式信息
     * 
     * @param fixedId 公式ID
     * @return 结果
     */
    public int deleteProFixedById(Long fixedId);
}
