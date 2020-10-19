package com.ruoyi.production.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.production.mapper.ProProductionMapper;
import com.ruoyi.production.domain.ProProduction;
import com.ruoyi.production.service.IProProductionService;
import com.ruoyi.common.core.text.Convert;

//import com.ruoyi.production.domain.ProSize;

/**
 * 产品Service业务层处理
 * 
 * @author Jonie
 * @date 2020-09-21
 */
@Service
public class ProProductionServiceImpl implements IProProductionService 
{
    @Autowired
    private ProProductionMapper proProductionMapper;

    /**
     * 查询产品
     * 
     * @param proId 产品ID
     * @return 产品
     */
    @Override
    public ProProduction selectProProductionById(Long proId)
    {
        return proProductionMapper.selectProProductionById(proId);
    }


    /**
     * 查询产品列表
     * 
     * @param proProduction 产品
     * @return 产品
     */
    @Override
    public List<ProProduction> selectProProductionList(ProProduction proProduction)
    {
        return proProductionMapper.selectProProductionList(proProduction);
    }


    /**
     * 新增产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    @Override
    public int insertProProduction(ProProduction proProduction)
    {
        int flag = 1;
        if(proProduction.getProClass().matches(".*整机.*")){
            ProProduction proProduction1 = new ProProduction();
            proProduction1.setProClass(proProduction.getProClass());
            proProduction1.setProProCompmodelno(proProduction.getProProCompmodelno());
            List<ProProduction> proProductionList1 = selectProProductionList(proProduction1);
            if(proProductionList1.size() != 0){
                flag = 0;
            }
        }else if(proProduction.getProClass().matches(".*裸机.*")){
            ProProduction proProduction1 = new ProProduction();
            proProduction1.setProClass(proProduction.getProClass());
            proProduction1.setProProBaremodelno(proProduction.getProProBaremodelno());
            List<ProProduction> proProductionList1 = selectProProductionList(proProduction1);
            if(proProductionList1.size() != 0){
                flag = 0;
            }
        }else{  //配件查看是否已经存在
            ProProduction proProduction1 = new ProProduction();
            proProduction1.setProClass(proProduction.getProClass());
            proProduction1.setProFitEnnomodelno(proProduction.getProFitEnnomodelno());
            List<ProProduction> proProductionList1 = selectProProductionList(proProduction1);
            if(proProductionList1.size() != 0){
                flag = 0;
            }
        }

        int res;
        if(flag == 0){
            StringBuilder failureMsg = new StringBuilder();
            failureMsg.insert(0, "数据已存在");
            res = 0;
            throw new BusinessException(failureMsg.toString());
        }else{
            res = proProductionMapper.insertProProduction(proProduction);
        }

        return res;
    }

    /**
     * 修改产品
     * 
     * @param proProduction 产品
     * @return 结果
     */
    @Override
    public int updateProProduction(ProProduction proProduction)
    {
        return proProductionMapper.updateProProduction(proProduction);
    }

    /**
     * 删除产品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProProductionByIds(String ids)
    {
        return proProductionMapper.deleteProProductionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品信息
     * 
     * @param proId 产品ID
     * @return 结果
     */
    @Override
    public int deleteProProductionById(Long proId)
    {
        return proProductionMapper.deleteProProductionById(proId);
    }

    /**
     * 返回产品分类
     * @return
     */
    public List<ProProduction> queryProductionClassList(){
        return proProductionMapper.queryProductionClassList();
    }

    /**
     * 根据产品分类 返回产品类型列表
     * @param selectedClass
     * @return
     */
    public List<ProProduction> queryProductionTypeList(String selectedClass){
        return proProductionMapper.queryProductionTypeList(selectedClass);
    }

    /**
     * 导入用户数据
     *
     * @param list 用户数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importData(List<ProProduction> list, boolean updateSupport, String operName)
    {
        if (StringUtils.isNull(list) || list.size() == 0)
        {
            throw new BusinessException("导入整机数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        List<ProProduction> proProductionList = selectProProductionList(null);
        for (ProProduction proProduction : list)
        {
            try
            {
                // 验证是否存在这个机型
                boolean proProductionFlag = false;

                for(ProProduction proProduction1 : proProductionList){
                    if(proProduction1.getProProCompmodelno().equals(proProduction.getProProCompmodelno())){
                        proProductionFlag = true;
                        break;
                    }
                }

                if (!proProductionFlag)
                {
                    insertProProduction(proProduction);
                    successNum++;
                    successMsg.append("<br/>" + successNum  + " 导入成功");
                }
                else if (updateSupport)
                {
                    updateProProduction(proProduction);
                    successNum++;
                    successMsg.append("<br/>" + successNum  + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

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


    public int saveFormula(String data){
        String saveColumn = data.substring(0,data.indexOf("="));
        String saveContent = data.substring(data.indexOf("=") + 1,data.length());
        saveContent = "\" " + saveContent + "\" ";
        String sqlInsert = " ";
        saveColumn = "\"" + saveColumn + "\"";
        sqlInsert = "form_content = " + saveContent + "where form_proterty = " + saveColumn;

        return proProductionMapper.saveFormula(sqlInsert);
    }

    public int execSql(String data){
        return proProductionMapper.execSql(data);
    }

    public int updateInsertByFormulaAndOrder(ProProduction proProduction){

//        List<ProFormula> proFormulaList =

        return 0;
    }

//    public ProSize selectProSizeById(Long id){
//
//        ProSize proSize = proProductionMapper.selectProSizeById(id);
//
//        return proSize;
//    }
//
//    public ProSize selectProSizeByBaremodelno(String proProBaremodelno){
//
//
//        ProSize proSize = proProductionMapper.selectProSizeByBaremodelno(proProBaremodelno);
//
//        return proSize;
//    }

    public List<ProProduction> selectProType(String proClass)
    {
        return proProductionMapper.selectProType(proClass);
    }

}
