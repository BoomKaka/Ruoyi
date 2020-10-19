package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ProFixed;

/**
 * 公式Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public interface ProFixedMapper 
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
     * 删除公式
     * 
     * @param fixedId 公式ID
     * @return 结果
     */
    public int deleteProFixedById(Long fixedId);

    /**
     * 批量删除公式
     * 
     * @param fixedIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFixedByIds(String[] fixedIds);
}
