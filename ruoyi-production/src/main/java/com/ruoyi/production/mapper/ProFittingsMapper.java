package com.ruoyi.production.mapper;

import java.util.List;
import com.ruoyi.production.domain.ProFittings;

/**
 * 配件Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
public interface ProFittingsMapper 
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

    /**
     * 查詢配件主类
     * @return
     */
    public List<ProFittings> selectfitMainclass();

    /**
     * 根据主类选择，查询辅类
     * @param fitMainclass
     * @return
     */
    public List<ProFittings> selectfitFuclass(String fitMainclass);

    /**
     * 查询桦汉型号，判断是已经添加配件，在导入功能里
     * @param fitEnnoModel
     * @return
     */
    public ProFittings selectProFittingsByEnnoModel(String fitEnnoModel);

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
     * 删除配件
     * 
     * @param fittingsId 配件ID
     * @return 结果
     */
    public int deleteProFittingsById(Integer fittingsId);

    /**
     * 批量删除配件
     *
     * @param fittingsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProFittingsByIds(String[] fittingsIds);
}
