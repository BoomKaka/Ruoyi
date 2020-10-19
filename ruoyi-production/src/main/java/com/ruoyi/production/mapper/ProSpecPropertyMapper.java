package com.ruoyi.production.mapper;

import java.util.List;

import com.ruoyi.production.domain.ProSpecProperty;
import org.springframework.stereotype.Repository;

/**
 * 规格属性Mapper接口
 * 
 * @author Jonie
 * @date 2020-10-09
 */
@Repository
public interface ProSpecPropertyMapper 
{
    /**
     * 查询规格属性
     * 
     * @param specpId 规格属性ID
     * @return 规格属性
     */
    public ProSpecProperty selectProSpecPropertyById(Long specpId);

    /**
     * 查询规格属性列表
     * 
     * @param proSpecProperty 规格属性
     * @return 规格属性集合
     */
    public List<ProSpecProperty> selectProSpecPropertyList(ProSpecProperty proSpecProperty);

    /**
     * 新增规格属性
     * 
     * @param proSpecProperty 规格属性
     * @return 结果
     */
    public int insertProSpecProperty(ProSpecProperty proSpecProperty);

    /**
     * 修改规格属性
     * 
     * @param proSpecProperty 规格属性
     * @return 结果
     */
    public int updateProSpecProperty(ProSpecProperty proSpecProperty);

    /**
     * 删除规格属性
     * 
     * @param specpId 规格属性ID
     * @return 结果
     */
    public int deleteProSpecPropertyById(Long specpId);

    /**
     * 批量删除规格属性
     * 
     * @param specpIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSpecPropertyByIds(String[] specpIds);

    public ProSpecProperty selectProSpecPropertyByName(ProSpecProperty proSpecProperty);

    //selectProSizepropertyListByParentId
    public List selectProSpecPropertyListByParentId(Long specpParentId);

    public List selectSpecInterfaceNameByParentId(Long specpParentId);
}
