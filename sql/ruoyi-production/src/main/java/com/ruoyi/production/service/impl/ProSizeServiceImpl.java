package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.production.mapper.ProSpecPropertyMapper;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProSizeMapper;
import com.ruoyi.production.domain.ProSize;
import com.ruoyi.production.service.IProSizeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 规格Service业务层处理
 * 
 * @author SueLiu
 * @date 2020-09-24
 */
@Service
public class ProSizeServiceImpl implements IProSizeService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private ProSizeMapper proSizeMapper;

    @Autowired
    private ProSpecPropertyMapper proSpecPropertyMapper;

    /**
     * 查询规格
     * 
     * @param sizeId 规格ID
     * @return 规格
     */
    @Override
    public ProSize selectProSizeById(Long sizeId)
    {
        return proSizeMapper.selectProSizeById(sizeId);
    }

    /**
     * 查询规格列表
     * 
     * @param proSize 规格
     * @return 规格
     */
    @Override
    public List<ProSize> selectProSizeList(ProSize proSize)
    {
        return proSizeMapper.selectProSizeList(proSize);
    }

    /**
     * 新增规格
     * 
     * @param proSize 规格
     * @return 结果
     */
    @Override
    public int insertProSize(ProSize proSize)
    {
        return proSizeMapper.insertProSize(proSize);
    }

    /**
     * 修改规格
     * 
     * @param proSize 规格
     * @return 结果
     */
    @Override
    public int updateProSize(ProSize proSize)
    {
        return proSizeMapper.updateProSize(proSize);
    }

    /**
     * 删除规格对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProSizeByIds(String ids)
    {
        return proSizeMapper.deleteProSizeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除规格信息
     * 
     * @param sizeId 规格ID
     * @return 结果
     */
    @Override
    public int deleteProSizeById(Long sizeId)
    {
        return proSizeMapper.deleteProSizeById(sizeId);
    }

    @Override
    public String importSize(List<ProSize> proList,boolean updateSupport, String operName) {
        System.out.println("导入产品数据不能为空！**************");
        if (StringUtils.isNull(proList) || proList.size() == 0)
        {
            throw new BusinessException("导入产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProSize psize : proList)
        {
            try
            {
                // 验证是否存在这个产品\
                ProSize pf = proSizeMapper.selectProSizeByModelNo(psize.getSizeModelno());

                if (StringUtils.isNull(pf))
                {
                    psize.setCreateBy(operName);
                    this.insertProSize(psize); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + psize.getSizeModelno() + " 导入成功");
                } else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + psize.getSizeModelno() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、产品 " + psize.getSizeModelno() + " 导入失败：";
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
