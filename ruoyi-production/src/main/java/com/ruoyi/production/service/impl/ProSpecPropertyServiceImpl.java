package com.ruoyi.production.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.system.service.impl.SysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProSpecPropertyMapper;
import com.ruoyi.production.domain.ProSpecProperty;
import com.ruoyi.production.service.IProSpecPropertyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 规格属性Service业务层处理
 * 
 * @author Jonie
 * @date 2020-10-09
 */
@Service
public class ProSpecPropertyServiceImpl implements IProSpecPropertyService 
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private ProSpecPropertyMapper proSpecPropertyMapper;

    /**
     * 查询规格属性
     * 
     * @param specpId 规格属性ID
     * @return 规格属性
     */
    @Override
    public ProSpecProperty selectProSpecPropertyById(Long specpId)
    {
        return proSpecPropertyMapper.selectProSpecPropertyById(specpId);
    }

    /**
     * 查询规格属性列表
     * 
     * @param proSpecProperty 规格属性
     * @return 规格属性
     */
    @Override
    public List<ProSpecProperty> selectProSpecPropertyList(ProSpecProperty proSpecProperty)
    {
        return proSpecPropertyMapper.selectProSpecPropertyList(proSpecProperty);
    }

    /**
     * 新增规格属性
     * 
     * @param proSpecProperty 规格属性
     * @return 结果
     */
    @Override
    public int insertProSpecProperty(ProSpecProperty proSpecProperty)
    {
        return proSpecPropertyMapper.insertProSpecProperty(proSpecProperty);
    }

    /**
     * 修改规格属性
     * 
     * @param proSpecProperty 规格属性
     * @return 结果
     */
    @Override
    public int updateProSpecProperty(ProSpecProperty proSpecProperty)
    {
        return proSpecPropertyMapper.updateProSpecProperty(proSpecProperty);
    }

    /**
     * 删除规格属性对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProSpecPropertyByIds(String ids)
    {
        return proSpecPropertyMapper.deleteProSpecPropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除规格属性信息
     * 
     * @param specpId 规格属性ID
     * @return 结果
     */
    @Override
    public int deleteProSpecPropertyById(Long specpId)
    {
        return proSpecPropertyMapper.deleteProSpecPropertyById(specpId);
    }

    /**
     * 查询规格属性树列表
     * 
     * @return 所有规格属性信息
     */
    @Override
    public List<Ztree> selectProSpecPropertyTree()
    {
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyMapper.selectProSpecPropertyList(new ProSpecProperty());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProSpecProperty proSpecProperty : proSpecPropertyList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(proSpecProperty.getSpecpId());
            ztree.setpId(proSpecProperty.getSpecpParentid());
            ztree.setName(proSpecProperty.getSpecpName());
            ztree.setTitle(proSpecProperty.getSpecpName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public String importProduction(List<ProProduction> proList, Boolean isUpdateSupport, String operName) {
        return null;
    }


    @Override
    public String importSpecProperty(List<ProSpecProperty> proSpecPropertyList, Boolean updateSupport, String operName){
        if (StringUtils.isNull(proSpecPropertyList) || proSpecPropertyList.size() == 0)
        {
            throw new BusinessException("导入产品数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (ProSpecProperty proSpecProperty : proSpecPropertyList)
        {
            try
            {
                // 验证是否存在这个产品\
                ProSpecProperty pf = proSpecPropertyMapper.selectProSpecPropertyByName(proSpecProperty);

                if (StringUtils.isNull(pf))
                {
                    proSpecProperty.setCreateBy(operName);
                    this.insertProSpecProperty(proSpecProperty); //insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、产品 " + proSpecProperty.getSpecpName() + " 导入成功");
                } else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、产品 " + proSpecProperty.getSpecpName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、产品 " + proSpecProperty.getSpecpName() + " 导入失败：";
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

    /**
     * 对象转规格属性树
     *
     * @param proSpecPropertyList
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<ProSpecProperty> proSpecPropertyList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProSpecProperty proSpecProperty : proSpecPropertyList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(proSpecProperty.getSpecpId());
            ztree.setpId(proSpecProperty.getSpecpParentid());
            ztree.setName(proSpecProperty.getSpecpName());
            ztree.setTitle(proSpecProperty.getSpecpName());
            //ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 查询规格属性管理树
     *
     * @param  proSpecProperty
     * @return 所有规格属性信息
     */
    @Override
    public List<Ztree> selectProSpecPropertyTree(ProSpecProperty proSpecProperty)
    {
        List<ProSpecProperty> proSpecPropertyList = proSpecPropertyMapper.selectProSpecPropertyList(proSpecProperty);
        List<Ztree> ztrees = initZtree(proSpecPropertyList);
        return ztrees;
    }

    /**
     * 查询规格属性管理树
     *
     * @param  specpParentId
     * @return 所有规格属性信息
     */
    @Override
    public List<Ztree> selectProSpecPropertyTreeByParentId(Long specpParentId)
    {
        List<ProSpecProperty> proSpecPropertyList = (List<ProSpecProperty>) proSpecPropertyMapper.selectProSpecPropertyListByParentId(specpParentId);
        List<Ztree> ztrees = initZtree(proSpecPropertyList);
        return ztrees;
    }

    /**
     *  通过父类id查询name
     * @param specpParentId
     * @return
     */
    public List<ProSpecProperty> selectSpecInterfaceNameByParentId(Long specpParentId){
        return proSpecPropertyMapper.selectSpecInterfaceNameByParentId(specpParentId);
    }
}
