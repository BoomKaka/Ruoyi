package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.production.domain.ProSize;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProSpecificationMapper;
import com.ruoyi.production.domain.ProSpecification;
import com.ruoyi.production.service.IProSpecificationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 规格表Service业务层处理
 * 
 * @author SueLiu
 * @date 2020-10-09
 */
@Service
public class ProSpecificationServiceImpl implements IProSpecificationService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private ProSpecificationMapper proSpecificationMapper;

    /**
     * 查询规格表
     * 
     * @param specId 规格表ID
     * @return 规格表
     */
    @Override
    public ProSpecification selectProSpecificationById(Long specId)
    {
        return proSpecificationMapper.selectProSpecificationById(specId);
    }

    /**
     * 查询规格表列表
     * 
     * @param proSpecification 规格表
     * @return 规格表
     */
    @Override
    public List<ProSpecification> selectProSpecificationList(ProSpecification proSpecification)
    {
        return proSpecificationMapper.selectProSpecificationList(proSpecification);
    }

    /**
     * 新增规格表
     * 
     * @param proSpecification 规格表
     * @return 结果
     */
    @Override
    public int insertProSpecification(ProSpecification proSpecification)
    {
        return proSpecificationMapper.insertProSpecification(proSpecification);
    }

    /**
     * 修改规格表
     * 
     * @param proSpecification 规格表
     * @return 结果
     */
    @Override
    public int updateProSpecification(ProSpecification proSpecification)
    {
        return proSpecificationMapper.updateProSpecification(proSpecification);
    }

    /**
     * 删除规格表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProSpecificationByIds(String ids)
    {
        return proSpecificationMapper.deleteProSpecificationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除规格表信息
     * 
     * @param specId 规格表ID
     * @return 结果
     */
    @Override
    public int deleteProSpecificationById(Long specId)
    {
        return proSpecificationMapper.deleteProSpecificationById(specId);
    }

    @Override
    public String importSpecification(List<ProSpecification> proList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(proList) || proList.size() == 0)
        {
            throw new BusinessException("导入产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProSpecification proSpec : proList)
        {
            try
            {
                // 验证是否存在这个产品\
                ProSpecification pf = proSpecificationMapper.selectProSpecByModelNo(proSpec.getSpecModelno());

                if (StringUtils.isNull(pf))
                {
                    proSpec.setCreateBy(operName);
                    this.insertProSpecification(proSpec); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + proSpec.getSpecModelno() + " 导入成功");
                } else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + proSpec.getSpecModelno() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、产品 " + proSpec.getSpecModelno() + " 导入失败：";
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
