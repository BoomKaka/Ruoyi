package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ProSize;

/**
 * 规格Mapper接口
 * 
 * @author SueLiu
 * @date 2020-09-24
 */
public interface ProSizeMapper 
{
    /**
     * 查询规格
     * 
     * @param sizeId 规格ID
     * @return 规格
     */
    public ProSize selectProSizeById(Long sizeId);

    /**
     * 查询规格列表
     * 
     * @param proSize 规格
     * @return 规格集合
     */
    public List<ProSize> selectProSizeList(ProSize proSize);

    /**
     * 新增规格
     * 
     * @param proSize 规格
     * @return 结果
     */
    public int insertProSize(ProSize proSize);

    /**
     * 修改规格
     * 
     * @param proSize 规格
     * @return 结果
     */
    public int updateProSize(ProSize proSize);

    /**
     * 删除规格
     * 
     * @param sizeId 规格ID
     * @return 结果
     */
    public int deleteProSizeById(Long sizeId);

    /**
     * 批量删除规格
     * 
     * @param sizeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProSizeByIds(String[] sizeIds);

    public ProSize selectProSizeByModelNo(String modelNo);
}
