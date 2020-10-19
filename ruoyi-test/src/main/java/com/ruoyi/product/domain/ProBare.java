package com.ruoyi.product.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 裸机对象 pro_bare
 * 
 * @author ruoyi
 * @date 2020-09-10
 */
public class ProBare extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 裸机id */
    private Integer bareId;

    /** 分类 */
    @Excel(name = "分类")
    private String bareClass;

    /** 类型 */
    @Excel(name = "类型")
    private String bareType;

    /** CPU/芯片 */
    @Excel(name = "CPU/芯片")
    private String bareCpu;

    /** 产品简述 */
    @Excel(name = "产品简述")
    private String bareDescribe;

    /** 裸机型号 */
    @Excel(name = "裸机型号")
    private String bareBareModel;

    /** 台北 */
    @Excel(name = "台北")
    private BigDecimal barePrice1;

    /** 白金 */
    @Excel(name = "白金")
    private BigDecimal barePrice2;

    /** 专营 */
    @Excel(name = "专营")
    private BigDecimal barePrice3;

    /** 特约 */
    @Excel(name = "特约")
    private BigDecimal barePrice4;

    /** 所属 */
    @Excel(name = "所属")
    private String bareBelong;

    /** cost */
    @Excel(name = "cost")
    private BigDecimal bareCost;

    /** 成本(含税) */
    @Excel(name = "成本(含税)")
    private BigDecimal bareCostTax;

    /** GP-台北 */
    @Excel(name = "GP-台北")
    private Long bareGp1;

    /** GP-白金 */
    @Excel(name = "GP-白金")
    private Long bareGp2;

    /** GP-专营 */
    @Excel(name = "GP-专营")
    private Long bareGp3;

    /** GP-特约 */
    @Excel(name = "GP-特约")
    private Long bareGp4;

    /** 预留 */
    @Excel(name = "预留")
    private BigDecimal bareReserve;

    /** 预留1 */
    @Excel(name = "预留1")
    private String bareReserve1;

    /** 预留2 */
    @Excel(name = "预留2")
    private String bareReserve2;

    /** 预留3 */
    @Excel(name = "预留3")
    private String bareReserve3;

    /** 预留4 */
    @Excel(name = "预留4")
    private String bareReserve4;

    /** 预留5 */
    @Excel(name = "预留5")
    private String bareReserve5;

    public void setBareId(Integer bareId) 
    {
        this.bareId = bareId;
    }

    public Integer getBareId() 
    {
        return bareId;
    }
    public void setBareClass(String bareClass) 
    {
        this.bareClass = bareClass;
    }

    public String getBareClass() 
    {
        return bareClass;
    }
    public void setBareType(String bareType) 
    {
        this.bareType = bareType;
    }

    public String getBareType() 
    {
        return bareType;
    }
    public void setBareCpu(String bareCpu) 
    {
        this.bareCpu = bareCpu;
    }

    public String getBareCpu() 
    {
        return bareCpu;
    }
    public void setBareDescribe(String bareDescribe) 
    {
        this.bareDescribe = bareDescribe;
    }

    public String getBareDescribe() 
    {
        return bareDescribe;
    }
    public void setBareBareModel(String bareBareModel) 
    {
        this.bareBareModel = bareBareModel;
    }

    public String getBareBareModel() 
    {
        return bareBareModel;
    }
    public void setBarePrice1(BigDecimal barePrice1) 
    {
        this.barePrice1 = barePrice1;
    }

    public BigDecimal getBarePrice1() 
    {
        return barePrice1;
    }
    public void setBarePrice2(BigDecimal barePrice2) 
    {
        this.barePrice2 = barePrice2;
    }

    public BigDecimal getBarePrice2() 
    {
        return barePrice2;
    }
    public void setBarePrice3(BigDecimal barePrice3) 
    {
        this.barePrice3 = barePrice3;
    }

    public BigDecimal getBarePrice3() 
    {
        return barePrice3;
    }
    public void setBarePrice4(BigDecimal barePrice4) 
    {
        this.barePrice4 = barePrice4;
    }

    public BigDecimal getBarePrice4() 
    {
        return barePrice4;
    }
    public void setBareBelong(String bareBelong) 
    {
        this.bareBelong = bareBelong;
    }

    public String getBareBelong() 
    {
        return bareBelong;
    }
    public void setBareCost(BigDecimal bareCost) 
    {
        this.bareCost = bareCost;
    }

    public BigDecimal getBareCost() 
    {
        return bareCost;
    }
    public void setBareCostTax(BigDecimal bareCostTax) 
    {
        this.bareCostTax = bareCostTax;
    }

    public BigDecimal getBareCostTax() 
    {
        return bareCostTax;
    }
    public void setBareGp1(Long bareGp1) 
    {
        this.bareGp1 = bareGp1;
    }

    public Long getBareGp1() 
    {
        return bareGp1;
    }
    public void setBareGp2(Long bareGp2) 
    {
        this.bareGp2 = bareGp2;
    }

    public Long getBareGp2() 
    {
        return bareGp2;
    }
    public void setBareGp3(Long bareGp3) 
    {
        this.bareGp3 = bareGp3;
    }

    public Long getBareGp3() 
    {
        return bareGp3;
    }
    public void setBareGp4(Long bareGp4) 
    {
        this.bareGp4 = bareGp4;
    }

    public Long getBareGp4() 
    {
        return bareGp4;
    }
    public void setBareReserve(BigDecimal bareReserve) 
    {
        this.bareReserve = bareReserve;
    }

    public BigDecimal getBareReserve() 
    {
        return bareReserve;
    }
    public void setBareReserve1(String bareReserve1) 
    {
        this.bareReserve1 = bareReserve1;
    }

    public String getBareReserve1() 
    {
        return bareReserve1;
    }
    public void setBareReserve2(String bareReserve2) 
    {
        this.bareReserve2 = bareReserve2;
    }

    public String getBareReserve2() 
    {
        return bareReserve2;
    }
    public void setBareReserve3(String bareReserve3) 
    {
        this.bareReserve3 = bareReserve3;
    }

    public String getBareReserve3() 
    {
        return bareReserve3;
    }
    public void setBareReserve4(String bareReserve4) 
    {
        this.bareReserve4 = bareReserve4;
    }

    public String getBareReserve4() 
    {
        return bareReserve4;
    }
    public void setBareReserve5(String bareReserve5) 
    {
        this.bareReserve5 = bareReserve5;
    }

    public String getBareReserve5() 
    {
        return bareReserve5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bareId", getBareId())
            .append("bareClass", getBareClass())
            .append("bareType", getBareType())
            .append("bareCpu", getBareCpu())
            .append("bareDescribe", getBareDescribe())
            .append("bareBareModel", getBareBareModel())
            .append("barePrice1", getBarePrice1())
            .append("barePrice2", getBarePrice2())
            .append("barePrice3", getBarePrice3())
            .append("barePrice4", getBarePrice4())
            .append("bareBelong", getBareBelong())
            .append("bareCost", getBareCost())
            .append("bareCostTax", getBareCostTax())
            .append("bareGp1", getBareGp1())
            .append("bareGp2", getBareGp2())
            .append("bareGp3", getBareGp3())
            .append("bareGp4", getBareGp4())
            .append("bareReserve", getBareReserve())
            .append("bareReserve1", getBareReserve1())
            .append("bareReserve2", getBareReserve2())
            .append("bareReserve3", getBareReserve3())
            .append("bareReserve4", getBareReserve4())
            .append("bareReserve5", getBareReserve5())
            .toString();
    }
}
