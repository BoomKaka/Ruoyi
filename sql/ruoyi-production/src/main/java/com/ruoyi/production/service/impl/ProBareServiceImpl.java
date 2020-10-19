package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProBareMapper;
import com.ruoyi.production.domain.ProBare;
import com.ruoyi.production.service.IProBareService;
import com.ruoyi.common.core.text.Convert;

/**
 * 裸机Service业务层处理
 * 
 * @author Jonie
 * @date 2020-09-14
 */
@Service
public class ProBareServiceImpl implements IProBareService 
{
    private static final Logger log = LoggerFactory.getLogger(ProBareServiceImpl.class);
    @Autowired
    private ProBareMapper proBareMapper;

    /**
     * 查询裸机
     * 
     * @param bareId 裸机ID
     * @return 裸机
     */
    @Override
    public ProBare selectProBareById(Integer bareId)
    {
        return proBareMapper.selectProBareById(bareId);
    }

    /**
     * 查询裸机列表
     * 
     * @param proBare 裸机
     * @return 裸机
     */
    @Override
    public List<ProBare> selectProBareList(ProBare proBare)
    {
        return proBareMapper.selectProBareList(proBare);
    }

    /**
     * 新增裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    @Override
    public int insertProBare(ProBare proBare)
    {
        return proBareMapper.insertProBare(proBare);
    }

    /**
     * 修改裸机
     * 
     * @param proBare 裸机
     * @return 结果
     */
    @Override
    public int updateProBare(ProBare proBare)
    {
        return proBareMapper.updateProBare(proBare);
    }

    /**
     * 通过裸机型号修改裸机
     *
     * @param proBare 裸机
     * @return 结果
     */
    @Override
    public int updateProBareByBareModel(ProBare proBare)
    {
        return proBareMapper.updateProBareByBareModel(proBare);
    }

    /**
     * 删除裸机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProBareByIds(String ids)
    {
        return proBareMapper.deleteProBareByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除裸机信息
     * 
     * @param bareId 裸机ID
     * @return 结果
     */
    @Override
    public int deleteProBareById(Integer bareId)
    {
        return proBareMapper.deleteProBareById(bareId);
    }

    /**
     * 导入裸机产品数据
     *
     * @param bareList 裸机产品数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return
     */
    @Override
    public String importBare(List<ProBare> bareList, Boolean isUpdateSupport){
        if (StringUtils.isNull(bareList) || bareList.size() == 0)
        {
            throw new BusinessException("导入裸机产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (ProBare bare : bareList)
        {
            try
            {
                // 验证是否存在这个裸机数据
                ProBare p = proBareMapper.selectBareByBareModel(bare.getBareBareModel());
                if (StringUtils.isNull(p))
                {
                    this.insertProBare(bare);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、裸机数据 " + bare.getBareBareModel() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    this.updateProBareByBareModel(bare);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、裸机数据 " + bare.getBareBareModel() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、裸机数据 " + bare.getBareBareModel() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、裸机数据 " + bare.getBareBareModel() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List<ProBare> queryProBareTypeList()
    {
        return proBareMapper.queryProBareTypeList();
    }
}
