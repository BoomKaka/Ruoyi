package com.ruoyi.production.service;

import java.util.List;
import com.ruoyi.production.domain.ProFittings;


/**
 * 配件Service接口
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
public interface IProFittingsService 
{
    /**
     * 查询配件
     * 
     * @param fittingsId 配件ID
     * @return 配件
     */
    public ProFittings selectProFittingsById(Integer fittingsId);


    /**
     * 查询配件列表
     * 
     * @param proFittings 配件
     * @return 配件集合
     */
    public List<ProFittings> selectProFittingsList(ProFittings proFittings);

    public List<ProFittings> selectfitMainclass();
    public List<ProFittings> selectfitFuclass(String fitMainclass);

    /**
     * 新增配件
     * 
     * @param proFittings 配件
     * @return 结果
     */
    public int insertProFittings(ProFittings proFittings);

    /**
     * 修改配件
     * 
     * @param proFittings 配件
     * @return 结果
     */
    public int updateProFittings(ProFittings proFittings);
    public int updateProFittingsByEnnoModel(ProFittings proFittings);

    /**
     * 批量删除配件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFittingsByIds(String ids);

    /**
     * 删除配件信息
     * 
     * @param fittingsId 配件ID
     * @return 结果
     */
    public int deleteProFittingsById(Integer fittingsId);

    /**
     *
     * @param fittingsList  配件列表
     * @param isUpdateSupport 判断是否导入
     * @param operName  执行导入操作的用户
     * @return 结果
     */
    public String importFittings(List<ProFittings> fittingsList, Boolean isUpdateSupport, String operName);
}
