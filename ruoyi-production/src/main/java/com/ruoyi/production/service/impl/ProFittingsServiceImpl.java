package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProFittingsMapper;
import com.ruoyi.production.domain.ProFittings;
import com.ruoyi.production.service.IProFittingsService;
import com.ruoyi.common.core.text.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 配件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
@Service
public class ProFittingsServiceImpl implements IProFittingsService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private ProFittingsMapper proFittingsMapper;



    /**
     * 查询配件
     * 
     * @param fittingsId 配件ID
     * @return 配件
     */
    @Override
    public ProFittings selectProFittingsById(Integer fittingsId)
    {
        return proFittingsMapper.selectProFittingsById(fittingsId);
    }


    /**
     * 查询配件列表
     * 
     * @param proFittings 配件
     * @return 配件
     */
    @Override
    public List<ProFittings> selectProFittingsList(ProFittings proFittings)
    {
        return proFittingsMapper.selectProFittingsList(proFittings);
    }

    @Override
    public List<ProFittings> selectfitMainclass() {
        return proFittingsMapper.selectfitMainclass();
    }

    @Override
    public List<ProFittings> selectfitFuclass(String fitMainclass) {
        return proFittingsMapper.selectfitFuclass(fitMainclass);
    }

    /**
     * 新增配件
     * 
     * @param proFittings 配件
     * @return 结果
     */
    @Override
    public int insertProFittings(ProFittings proFittings)
    {
        return proFittingsMapper.insertProFittings(proFittings);
    }

    /**
     * 修改配件
     * 
     * @param proFittings 配件
     * @return 结果
     */
    @Override
    public int updateProFittings(ProFittings proFittings)
    {
        System.out.println("更新开始！ServiceImpl层 进入Mapper层接口");
        return proFittingsMapper.updateProFittings(proFittings);
    }

    @Override
    public int updateProFittingsByEnnoModel(ProFittings proFittings) {
        return proFittingsMapper.updateProFittingsByEnnoModel(proFittings);
    }

    /**
     * 删除配件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProFittingsByIds(String ids)
    {
        return proFittingsMapper.deleteProFittingsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配件信息
     * 
     * @param fittingsId 配件ID
     * @return 结果
     */
    @Override
    public int deleteProFittingsById(Integer fittingsId)
    {
        return proFittingsMapper.deleteProFittingsById(fittingsId);
    }



    @Override
    public String importFittings(List<ProFittings> fittingsList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(fittingsList) || fittingsList.size() == 0)
        {
            throw new BusinessException("导入配件数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProFittings fittings : fittingsList)
        {
            try
            {
                // 验证是否存在这个配件\
                ProFittings pf = proFittingsMapper.selectProFittingsByEnnoModel(fittings.getFitEnnoModel());
                //SysUser u = userMapper.selectUserByLoginName(fittings.getLoginName());
                if (StringUtils.isNull(pf))
                {
                    fittings.setCreateBy(operName);
                    this.insertProFittings(fittings); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、配件 " + fittings.getFitEnnoModel() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    fittings.setUpdateBy(operName);
                    System.out.println("更新开始！ServiceImpl层");
                    this.updateProFittingsByEnnoModel(fittings);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、配件 " + fittings.getFitEnnoModel() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、配件 " + fittings.getFitEnnoModel() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、配件 " + fittings.getFitEnnoModel() + " 导入失败：";
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
}
