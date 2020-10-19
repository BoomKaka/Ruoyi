package com.ruoyi.production.mapper;

import java.util.List;

//import com.ruoyi.production.domain.ProSizeproperty;
import com.ruoyi.production.domain.ProSpecification;

/**
 * 规格表Mapper接口
 * 
 * @author SueLiu
 * @date 2020-10-09
 */
public interface ProSpecificationMapper 
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
     * 删除规格表
     * 
     * @param specId 规格表ID
     * @return 结果
     */
    public int deleteProSpecificationById(Long specId);

    /**
     * 批量删除规格表
     * 
     * @param specIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSpecificationByIds(String[] specIds);

    public ProSpecification selectProSpecByModelNo(String modelNo);
}
