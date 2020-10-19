package com.ruoyi.production.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公式对象 pro_formula
 * 
 * @author ruoyi
 * @date 2020-10-10
 */
public class ProFormula extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公式ID */
    private Long formId;

    /** 公式中文名称 */
    @Excel(name = "公式中文名称")
    private String formName;

    /** 公式英文字段 */
    @Excel(name = "公式英文字段")
    private String formProterty;

    /** 公式内容 */
    @Excel(name = "公式内容")
    private String formContent;

    /** 执行顺序 */
    @Excel(name = "执行顺序")
    private Integer formOrder;

    public void setFormId(Long formId) 
    {
        this.formId = formId;
    }

    public Long getFormId() 
    {
        return formId;
    }
    public void setFormName(String formName) 
    {
        this.formName = formName;
    }

    public String getFormName() 
    {
        return formName;
    }
    public void setFormProterty(String formProterty) 
    {
        this.formProterty = formProterty;
    }

    public String getFormProterty() 
    {
        return formProterty;
    }
    public void setFormContent(String formContent) 
    {
        this.formContent = formContent;
    }

    public String getFormContent() 
    {
        return formContent;
    }
    public void setFormOrder(Integer formOrder) 
    {
        this.formOrder = formOrder;
    }

    public Integer getFormOrder() 
    {
        return formOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("formId", getFormId())
            .append("formName", getFormName())
            .append("formProterty", getFormProterty())
            .append("formContent", getFormContent())
            .append("formOrder", getFormOrder())
            .toString();
    }
}
