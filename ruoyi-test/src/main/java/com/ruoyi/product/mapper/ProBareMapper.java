package com.ruoyi.product.mapper;

import java.util.List;
import com.ruoyi.product.domain.ProBare;
import org.springframework.stereotype.Repository;

/**
 * 裸机Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
@Repository
public interface ProBareMapper 
{
    /**
     * 查询裸机
     * 
     * @param bareId 裸机ID
     * @return 裸机
     */
    public ProBare selectProBareById(Integer bareId);

    /**
     * 查询裸机列表
     * 
     * @param proBare 裸机
     * @return 裸机集合
     */
    public List<ProBare> selectProBareList(ProBare proBare);

    /**
     * 新增裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    public int insertProBare(ProBare proBare);

    /**
     * 修改裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    public int updateProBare(ProBare proBare);

    /**
     * 删除裸机
     * 
     * @param bareId 裸机ID
     * @return 结果
     */
    public int deleteProBareById(Integer bareId);

    /**
     * 批量删除裸机
     * 
     * @param bareIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProBareByIds(String[] bareIds);

    /**
     * 通过裸机型号查询裸机产品数据
     *
     * @param bareBareModel 裸机型号
     * @return
     */
    public ProBare selectBareByBareModel(String bareBareModel);

}
