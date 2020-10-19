package com.ruoyi.production.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公式对象 pro_fixed
 * 
 * @author ruoyi
 * @date 2020-09-16
 */
public class ProFixed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long fixedId;

    /** 名称 */
    @Excel(name = "名称")
    private String fixedName;

    /** 值 */
    @Excel(name = "值")
    private Double fixedValue;

    /** 公式内容 */
    @Excel(name = "公式内容")
    private String fixedContext;

    public void setFixedId(Long fixedId) 
    {
        this.fixedId = fixedId;
    }

    public Long getFixedId() 
    {
        return fixedId;
    }
    public void setFixedName(String fixedName) 
    {
        this.fixedName = fixedName;
    }

    public String getFixedName() 
    {
        return fixedName;
    }
    public void setFixedValue(Double fixedValue)
    {
        this.fixedValue = fixedValue;
    }

    public Double getFixedValue()
    {
        return fixedValue;
    }
    public void setFixedContext(String fixedContext) 
    {
        this.fixedContext = fixedContext;
    }

    public String getFixedContext() 
    {
        return fixedContext;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fixedId", getFixedId())
            .append("fixedName", getFixedName())
            .append("fixedValue", getFixedValue())
            .append("fixedContext", getFixedContext())
            .toString();
    }
}
