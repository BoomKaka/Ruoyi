package com.ruoyi.production.service;

import java.util.List;

import com.ruoyi.production.domain.ProSize;
import com.ruoyi.production.domain.ProSpecification;

/**
 * 规格表Service接口
 * 
 * @author SueLiu
 * @date 2020-10-09
 */
public interface IProSpecificationService 
{
    /**
     * 查询规格表
     * 
     * @param specId 规格表ID
     * @return 规格表
     */
    public ProSpecification selectProSpecificationById(Long specId);

    /**
     * 查询规格表列表
     * 
     * @param proSpecification 规格表
     * @return 规格表集合
     */
    public List<ProSpecification> selectProSpecificationList(ProSpecification proSpecification);

    /**
     * 新增规格表
     * 
     * @param proSpecification 规格表
     * @return 结果
     */
    public int insertProSpecification(ProSpecification proSpecification);

    /**
     * 修改规格表
     * 
     * @param proSpecification 规格表
     * @return 结果
     */
    public int updateProSpecification(ProSpecification proSpecification);

    /**
     * 批量删除规格表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSpecificationByIds(String ids);

    /**
     * 删除规格表信息
     * 
     * @param specId 规格表ID
     * @return 结果
     */
    public int deleteProSpecificationById(Long specId);

    public String importSpecification(List<ProSpecification> proList, boolean updateSupport, String operName);
}
