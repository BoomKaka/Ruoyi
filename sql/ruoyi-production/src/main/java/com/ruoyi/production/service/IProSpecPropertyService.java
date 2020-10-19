package com.ruoyi.production.service;

import java.util.List;

import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.domain.ProSpecProperty;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 规格属性Service接口
 * 
 * @author Jonie
 * @date 2020-10-09
 */
public interface IProSpecPropertyService 
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
     * 批量删除规格属性
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSpecPropertyByIds(String ids);

    /**
     * 删除规格属性信息
     * 
     * @param specpId 规格属性ID
     * @return 结果
     */
    public int deleteProSpecPropertyById(Long specpId);

    /**
     * 查询规格属性树列表
     * 
     * @return 所有规格属性信息
     */
    public List<Ztree> selectProSpecPropertyTree();

    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName);

    String importSpecProperty(List<ProSpecProperty> proSpecPropertyList, Boolean updateSupport, String operName);

    public List<Ztree> selectProSpecPropertyTree(ProSpecProperty proSpecProperty);

    public List<Ztree> selectProSpecPropertyTreeByParentId(Long specpParentId);

    public List<ProSpecProperty> selectSpecInterfaceNameByParentId(Long specParentId);
}
