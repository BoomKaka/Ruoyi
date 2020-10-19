package com.ruoyi.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配件对象 pro_fittings
 * 
 * @author ruoyi
 * @date 2020-09-14
 */
public class ProFittings extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer fittingsId;

    /** 主类 */
    @Excel(name = "主类")
    private String fitMainclass;

    /** 辅类 */
    @Excel(name = "辅类")
    private String fitFuclass;

    /** 桦汉型号 */
    @Excel(name = "桦汉型号")
    private String fitEnnoModel;

    /** 料号 */
    @Excel(name = "料号")
    private String fitItemno;

    /** MQQ(pcs) */
    @Excel(name = "MQQ(pcs)")
    private Integer fitMqq;

    /** Price */
    @Excel(name = "Price")
    private BigDecimal fitPrice;

    /** 含税价格 */
    @Excel(name = "含税价格")
    private BigDecimal fitPriceTax;

    /** 产品简述 */
    @Excel(name = "产品简述")
    private String fitDescribe;

    /** update */
    @Excel(name = "update", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fitUpdate;

    /** Cost */
    @Excel(name = "Cost")
    private BigDecimal fitCost;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private BigDecimal fitCostTax;

    /** 不可动 */
    @Excel(name = "不可动")
    private BigDecimal fitNochange;

    /** 预留 */
    @Excel(name = "预留")
    private BigDecimal fitReserve;

    /** GP */
    @Excel(name = "GP")
    private Double fitGp;

    /** 供应商 */
    @Excel(name = "供应商")
    private String fitSupplier;

    /** 供应商料号 */
    @Excel(name = "供应商料号")
    private String fitSuppItemno;

    /** 其他 */
    @Excel(name = "其他")
    private String fitOther;

    /** P/N */
    @Excel(name = "P/N")
    private String fitPn;

    /** Fan Price */
    @Excel(name = "Fan Price")
    private BigDecimal fitFanePrice;

    /** 风扇价格 */
    @Excel(name = "风扇价格")
    private BigDecimal fitFancPrice;

    /** 未税成本 */
    @Excel(name = "未税成本")
    private BigDecimal fitCostOther;

    /** 厂商税率 */
    @Excel(name = "厂商税率")
    private Long fitManufacturerrate;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private BigDecimal fitCosttaxOther;

    /** GP */
    @Excel(name = "GP")
    private Double fitGpOther;

    /** 预留1 */
    @Excel(name = "预留1")
    private String fitReserve1;

    /** 预留2 */
    @Excel(name = "预留2")
    private String fitReserve2;

    /** 预留3 */
    @Excel(name = "预留3")
    private String fitReserve3;

    /** 预留4 */
    @Excel(name = "预留4")
    private String fitReserve4;

    /** 预留5 */
    @Excel(name = "预留5")
    private String fitReserve5;

    public void setFittingsId(Integer fittingsId) 
    {
        this.fittingsId = fittingsId;
    }

    public Integer getFittingsId() 
    {
        return fittingsId;
    }
    public void setFitMainclass(String fitMainclass) 
    {
        this.fitMainclass = fitMainclass;
    }

    public String getFitMainclass() 
    {
        return fitMainclass;
    }
    public void setFitFuclass(String fitFuclass) 
    {
        this.fitFuclass = fitFuclass;
    }

    public String getFitFuclass() 
    {
        return fitFuclass;
    }
    public void setFitEnnoModel(String fitEnnoModel) 
    {
        this.fitEnnoModel = fitEnnoModel;
    }

    public String getFitEnnoModel() 
    {
        return fitEnnoModel;
    }
    public void setFitItemno(String fitItemno) 
    {
        this.fitItemno = fitItemno;
    }

    public String getFitItemno() 
    {
        return fitItemno;
    }
    public void setFitMqq(Integer fitMqq) 
    {
        this.fitMqq = fitMqq;
    }

    public Integer getFitMqq() 
    {
        return fitMqq;
    }
    public void setFitPrice(BigDecimal fitPrice) 
    {
        this.fitPrice = fitPrice;
    }

    public BigDecimal getFitPrice() 
    {
        return fitPrice;
    }
    public void setFitPriceTax(BigDecimal fitPriceTax) 
    {
        this.fitPriceTax = fitPriceTax;
    }

    public BigDecimal getFitPriceTax() 
    {
        return fitPriceTax;
    }
    public void setFitDescribe(String fitDescribe) 
    {
        this.fitDescribe = fitDescribe;
    }

    public String getFitDescribe() 
    {
        return fitDescribe;
    }
    public void setFitUpdate(Date fitUpdate) 
    {
        this.fitUpdate = fitUpdate;
    }

    public Date getFitUpdate() 
    {
        return fitUpdate;
    }
    public void setFitCost(BigDecimal fitCost) 
    {
        this.fitCost = fitCost;
    }

    public BigDecimal getFitCost() 
    {
        return fitCost;
    }
    public void setFitCostTax(BigDecimal fitCostTax) 
    {
        this.fitCostTax = fitCostTax;
    }

    public BigDecimal getFitCostTax() 
    {
        return fitCostTax;
    }
    public void setFitNochange(BigDecimal fitNochange) 
    {
        this.fitNochange = fitNochange;
    }

    public BigDecimal getFitNochange() 
    {
        return fitNochange;
    }
    public void setFitReserve(BigDecimal fitReserve) 
    {
        this.fitReserve = fitReserve;
    }

    public BigDecimal getFitReserve() 
    {
        return fitReserve;
    }
    public void setFitGp(Double fitGp)
    {
        this.fitGp = fitGp;
    }

    public Double getFitGp()
    {
        return fitGp;
    }
    public void setFitSupplier(String fitSupplier) 
    {
        this.fitSupplier = fitSupplier;
    }

    public String getFitSupplier() 
    {
        return fitSupplier;
    }
    public void setFitSuppItemno(String fitSuppItemno) 
    {
        this.fitSuppItemno = fitSuppItemno;
    }

    public String getFitSuppItemno() 
    {
        return fitSuppItemno;
    }
    public void setFitOther(String fitOther) 
    {
        this.fitOther = fitOther;
    }

    public String getFitOther() 
    {
        return fitOther;
    }
    public void setFitPn(String fitPn) 
    {
        this.fitPn = fitPn;
    }

    public String getFitPn() 
    {
        return fitPn;
    }
    public void setFitFanePrice(BigDecimal fitFanePrice) 
    {
        this.fitFanePrice = fitFanePrice;
    }

    public BigDecimal getFitFanePrice() 
    {
        return fitFanePrice;
    }
    public void setFitFancPrice(BigDecimal fitFancPrice) 
    {
        this.fitFancPrice = fitFancPrice;
    }

    public BigDecimal getFitFancPrice() 
    {
        return fitFancPrice;
    }
    public void setFitCostOther(BigDecimal fitCostOther) 
    {
        this.fitCostOther = fitCostOther;
    }

    public BigDecimal getFitCostOther() 
    {
        return fitCostOther;
    }
    public void setFitManufacturerrate(Long fitManufacturerrate) 
    {
        this.fitManufacturerrate = fitManufacturerrate;
    }

    public Long getFitManufacturerrate() 
    {
        return fitManufacturerrate;
    }
    public void setFitCosttaxOther(BigDecimal fitCosttaxOther) 
    {
        this.fitCosttaxOther = fitCosttaxOther;
    }

    public BigDecimal getFitCosttaxOther() 
    {
        return fitCosttaxOther;
    }
    public void setFitGpOther(Double fitGpOther)
    {
        this.fitGpOther = fitGpOther;
    }

    public Double getFitGpOther()
    {
        return fitGpOther;
    }
    public void setFitReserve1(String fitReserve1) 
    {
        this.fitReserve1 = fitReserve1;
    }

    public String getFitReserve1() 
    {
        return fitReserve1;
    }
    public void setFitReserve2(String fitReserve2) 
    {
        this.fitReserve2 = fitReserve2;
    }

    public String getFitReserve2() 
    {
        return fitReserve2;
    }
    public void setFitReserve3(String fitReserve3) 
    {
        this.fitReserve3 = fitReserve3;
    }

    public String getFitReserve3() 
    {
        return fitReserve3;
    }
    public void setFitReserve4(String fitReserve4) 
    {
        this.fitReserve4 = fitReserve4;
    }

    public String getFitReserve4() 
    {
        return fitReserve4;
    }
    public void setFitReserve5(String fitReserve5) 
    {
        this.fitReserve5 = fitReserve5;
    }

    public String getFitReserve5() 
    {
        return fitReserve5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fittingsId", getFittingsId())
            .append("fitMainclass", getFitMainclass())
            .append("fitFuclass", getFitFuclass())
            .append("fitEnnoModel", getFitEnnoModel())
            .append("fitItemno", getFitItemno())
            .append("fitMqq", getFitMqq())
            .append("fitPrice", getFitPrice())
            .append("fitPriceTax", getFitPriceTax())
            .append("fitDescribe", getFitDescribe())
            .append("fitUpdate", getFitUpdate())
            .append("fitCost", getFitCost())
            .append("fitCostTax", getFitCostTax())
            .append("fitNochange", getFitNochange())
            .append("fitReserve", getFitReserve())
            .append("fitGp", getFitGp())
            .append("fitSupplier", getFitSupplier())
            .append("fitSuppItemno", getFitSuppItemno())
            .append("fitOther", getFitOther())
            .append("fitPn", getFitPn())
            .append("fitFanePrice", getFitFanePrice())
            .append("fitFancPrice", getFitFancPrice())
            .append("fitCostOther", getFitCostOther())
            .append("fitManufacturerrate", getFitManufacturerrate())
            .append("fitCosttaxOther", getFitCosttaxOther())
            .append("fitGpOther", getFitGpOther())
            .append("fitReserve1", getFitReserve1())
            .append("fitReserve2", getFitReserve2())
            .append("fitReserve3", getFitReserve3())
            .append("fitReserve4", getFitReserve4())
            .append("fitReserve5", getFitReserve5())
            .toString();
    }
}
