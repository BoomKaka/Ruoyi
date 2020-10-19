package com.ruoyi.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品对象 pro_production
 * 
 * @author Jonie
 * @date 2020-09-21
 */
public class ProProduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long proId;

    /** 分类 */
    @Excel(name = "分类")
    private String proClass;

    /** 类型 */
    @Excel(name = "类型")
    private String proType;

    /** 产品描述 */
    @Excel(name = "产品描述")
    private String proDecribes;

    /** CPU/芯片 */
    @Excel(name = "CPU/芯片")
    private String proProCpu;

    /** 内存 */
    @Excel(name = "内存")
    private String proProMemory;

    /** 存储1 */
    @Excel(name = "存储1")
    private String proProStorage1;

    /** 存储2 */
    @Excel(name = "存储2")
    private String proProStorage2;

    /** 其他 */
    @Excel(name = "其他")
    private String proProOther;

    /** 裸机型号 */
    @Excel(name = "裸机型号")
    private String proProBaremodelno;

    /** 整机型号 */
    @Excel(name = "整机型号")
    private String proProCompmodelno;

    /** 台北价 */
    @Excel(name = "台北价")
    private BigDecimal proProPrice1;

    /** 白金价 */
    @Excel(name = "白金价")
    private BigDecimal proProPrice2;

    /** 专营价 */
    @Excel(name = "专营价")
    private BigDecimal proProPrice3;

    /** 特约价 */
    @Excel(name = "特约价")
    private BigDecimal proProPrice4;

    /** 所属 */
    @Excel(name = "所属")
    private String proProBelongto;

    /** cost */
    @Excel(name = "cost")
    private BigDecimal proCost;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private BigDecimal proCostIncludetax;

    /** 预留 */
    @Excel(name = "预留")
    private BigDecimal proReverse;

    /** GP台北 */
    @Excel(name = "GP台北")
    private Long proProGp1;

    /** GP白金 */
    @Excel(name = "GP白金")
    private Long proProGp2;

    /** GP专营 */
    @Excel(name = "GP专营")
    private Long proProGp3;

    /** GP特约 */
    @Excel(name = "GP特约")
    private Long proProGp4;

    /** 辅类 */
    @Excel(name = "辅类")
    private String proFitSubclass;

    /** 桦汉型号 */
    @Excel(name = "桦汉型号")
    private String proFitEnnomodelno;

    /** 料号 */
    @Excel(name = "料号")
    private String proFitPartnumber;

    /** MQQ(pcs) */
    @Excel(name = "MQQ(pcs)")
    private Long proFitMqq;

    /** Price */
    @Excel(name = "Price")
    private BigDecimal proFitPrice;

    /** 含税价格 */
    @Excel(name = "含税价格")
    private BigDecimal proFitPriceincludetax;

    /** 不可动 */
    @Excel(name = "不可动")
    private Long proFitNomove;

    /** fit GP */
    @Excel(name = "fit GP")
    private BigDecimal proFitGp;

    /** 供应商 */
    @Excel(name = "供应商")
    private String proFitSupplier;

    /** 供应商料号 */
    @Excel(name = "供应商料号")
    private String proFitSupppartnumber;

    /** 其他 */
    @Excel(name = "其他")
    private String proFitOther;

    /** P/N */
    @Excel(name = "P/N")
    private String proFitPn;

    /** Fan Price */
    @Excel(name = "Fan Price")
    private BigDecimal proFitFanprice;

    /** 风扇价格 */
    @Excel(name = "风扇价格")
    private BigDecimal proFitFanprice1;

    /** 未税成本 */
    @Excel(name = "未税成本")
    private BigDecimal proFitFancost;

    /** 厂商税 */
    @Excel(name = "厂商税")
    private Long proFitManufacturntax;

    /** 含税成本 */
    @Excel(name = "含税成本")
    private BigDecimal proFitCosttax;

    /** fan GP */
    @Excel(name = "fan GP")
    private Long proFitFangp;

    /** 更新日期 */
    //@Excel(name = "更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date proUpdate;

    public void setProId(Long proId) 
    {
        this.proId = proId;
    }

    public Long getProId() 
    {
        return proId;
    }
    public void setProClass(String proClass) 
    {
        this.proClass = proClass;
    }

    public String getProClass() 
    {
        return proClass;
    }
    public void setProType(String proType) 
    {
        this.proType = proType;
    }

    public String getProType() 
    {
        return proType;
    }
    public void setProDecribes(String proDecribes) 
    {
        this.proDecribes = proDecribes;
    }

    public String getProDecribes() 
    {
        return proDecribes;
    }
    public void setProProCpu(String proProCpu) 
    {
        this.proProCpu = proProCpu;
    }

    public String getProProCpu() 
    {
        return proProCpu;
    }
    public void setProProMemory(String proProMemory) 
    {
        this.proProMemory = proProMemory;
    }

    public String getProProMemory() 
    {
        return proProMemory;
    }
    public void setProProStorage1(String proProStorage1) 
    {
        this.proProStorage1 = proProStorage1;
    }

    public String getProProStorage1() 
    {
        return proProStorage1;
    }
    public void setProProStorage2(String proProStorage2) 
    {
        this.proProStorage2 = proProStorage2;
    }

    public String getProProStorage2() 
    {
        return proProStorage2;
    }
    public void setProProOther(String proProOther) 
    {
        this.proProOther = proProOther;
    }

    public String getProProOther() 
    {
        return proProOther;
    }
    public void setProProBaremodelno(String proProBaremodelno) 
    {
        this.proProBaremodelno = proProBaremodelno;
    }

    public String getProProBaremodelno() 
    {
        return proProBaremodelno;
    }
    public void setProProCompmodelno(String proProCompmodelno) 
    {
        this.proProCompmodelno = proProCompmodelno;
    }

    public String getProProCompmodelno() 
    {
        return proProCompmodelno;
    }
    public void setProProPrice1(BigDecimal proProPrice1) 
    {
        this.proProPrice1 = proProPrice1;
    }

    public BigDecimal getProProPrice1() 
    {
        return proProPrice1;
    }
    public void setProProPrice2(BigDecimal proProPrice2) 
    {
        this.proProPrice2 = proProPrice2;
    }

    public BigDecimal getProProPrice2() 
    {
        return proProPrice2;
    }
    public void setProProPrice3(BigDecimal proProPrice3) 
    {
        this.proProPrice3 = proProPrice3;
    }

    public BigDecimal getProProPrice3() 
    {
        return proProPrice3;
    }
    public void setProProPrice4(BigDecimal proProPrice4) 
    {
        this.proProPrice4 = proProPrice4;
    }

    public BigDecimal getProProPrice4() 
    {
        return proProPrice4;
    }
    public void setProProBelongto(String proProBelongto) 
    {
        this.proProBelongto = proProBelongto;
    }

    public String getProProBelongto() 
    {
        return proProBelongto;
    }
    public void setProCost(BigDecimal proCost) 
    {
        this.proCost = proCost;
    }

    public BigDecimal getProCost() 
    {
        return proCost;
    }
    public void setProCostIncludetax(BigDecimal proCostIncludetax) 
    {
        this.proCostIncludetax = proCostIncludetax;
    }

    public BigDecimal getProCostIncludetax() 
    {
        return proCostIncludetax;
    }
    public void setProReverse(BigDecimal proReverse) 
    {
        this.proReverse = proReverse;
    }

    public BigDecimal getProReverse() 
    {
        return proReverse;
    }
    public void setProProGp1(Long proProGp1) 
    {
        this.proProGp1 = proProGp1;
    }

    public Long getProProGp1() 
    {
        return proProGp1;
    }
    public void setProProGp2(Long proProGp2) 
    {
        this.proProGp2 = proProGp2;
    }

    public Long getProProGp2() 
    {
        return proProGp2;
    }
    public void setProProGp3(Long proProGp3) 
    {
        this.proProGp3 = proProGp3;
    }

    public Long getProProGp3() 
    {
        return proProGp3;
    }
    public void setProProGp4(Long proProGp4) 
    {
        this.proProGp4 = proProGp4;
    }

    public Long getProProGp4() 
    {
        return proProGp4;
    }
    public void setProFitSubclass(String proFitSubclass) 
    {
        this.proFitSubclass = proFitSubclass;
    }

    public String getProFitSubclass() 
    {
        return proFitSubclass;
    }
    public void setProFitEnnomodelno(String proFitEnnomodelno) 
    {
        this.proFitEnnomodelno = proFitEnnomodelno;
    }

    public String getProFitEnnomodelno() 
    {
        return proFitEnnomodelno;
    }
    public void setProFitPartnumber(String proFitPartnumber) 
    {
        this.proFitPartnumber = proFitPartnumber;
    }

    public String getProFitPartnumber() 
    {
        return proFitPartnumber;
    }
    public void setProFitMqq(Long proFitMqq) 
    {
        this.proFitMqq = proFitMqq;
    }

    public Long getProFitMqq() 
    {
        return proFitMqq;
    }
    public void setProFitPrice(BigDecimal proFitPrice) 
    {
        this.proFitPrice = proFitPrice;
    }

    public BigDecimal getProFitPrice() 
    {
        return proFitPrice;
    }
    public void setProFitPriceincludetax(BigDecimal proFitPriceincludetax) 
    {
        this.proFitPriceincludetax = proFitPriceincludetax;
    }

    public BigDecimal getProFitPriceincludetax() 
    {
        return proFitPriceincludetax;
    }
    public void setProFitNomove(Long proFitNomove) 
    {
        this.proFitNomove = proFitNomove;
    }

    public Long getProFitNomove() 
    {
        return proFitNomove;
    }
    public void setProFitGp(BigDecimal proFitGp) 
    {
        this.proFitGp = proFitGp;
    }

    public BigDecimal getProFitGp() 
    {
        return proFitGp;
    }
    public void setProFitSupplier(String proFitSupplier) 
    {
        this.proFitSupplier = proFitSupplier;
    }

    public String getProFitSupplier() 
    {
        return proFitSupplier;
    }
    public void setProFitSupppartnumber(String proFitSupppartnumber) 
    {
        this.proFitSupppartnumber = proFitSupppartnumber;
    }

    public String getProFitSupppartnumber() 
    {
        return proFitSupppartnumber;
    }
    public void setProFitOther(String proFitOther) 
    {
        this.proFitOther = proFitOther;
    }

    public String getProFitOther() 
    {
        return proFitOther;
    }
    public void setProFitPn(String proFitPn) 
    {
        this.proFitPn = proFitPn;
    }

    public String getProFitPn() 
    {
        return proFitPn;
    }
    public void setProFitFanprice(BigDecimal proFitFanprice) 
    {
        this.proFitFanprice = proFitFanprice;
    }

    public BigDecimal getProFitFanprice() 
    {
        return proFitFanprice;
    }
    public void setProFitFanprice1(BigDecimal proFitFanprice1) 
    {
        this.proFitFanprice1 = proFitFanprice1;
    }

    public BigDecimal getProFitFanprice1() 
    {
        return proFitFanprice1;
    }
    public void setProFitFancost(BigDecimal proFitFancost) 
    {
        this.proFitFancost = proFitFancost;
    }

    public BigDecimal getProFitFancost() 
    {
        return proFitFancost;
    }
    public void setProFitManufacturntax(Long proFitManufacturntax) 
    {
        this.proFitManufacturntax = proFitManufacturntax;
    }

    public Long getProFitManufacturntax() 
    {
        return proFitManufacturntax;
    }
    public void setProFitCosttax(BigDecimal proFitCosttax) 
    {
        this.proFitCosttax = proFitCosttax;
    }

    public BigDecimal getProFitCosttax() 
    {
        return proFitCosttax;
    }
    public void setProFitFangp(Long proFitFangp) 
    {
        this.proFitFangp = proFitFangp;
    }

    public Long getProFitFangp() 
    {
        return proFitFangp;
    }
    public void setProUpdate(Date proUpdate) 
    {
        this.proUpdate = proUpdate;
    }

    public Date getProUpdate() 
    {
        return proUpdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("proId", getProId())
            .append("proClass", getProClass())
            .append("proType", getProType())
            .append("proDecribes", getProDecribes())
            .append("proProCpu", getProProCpu())
            .append("proProMemory", getProProMemory())
            .append("proProStorage1", getProProStorage1())
            .append("proProStorage2", getProProStorage2())
            .append("proProOther", getProProOther())
            .append("proProBaremodelno", getProProBaremodelno())
            .append("proProCompmodelno", getProProCompmodelno())
            .append("proProPrice1", getProProPrice1())
            .append("proProPrice2", getProProPrice2())
            .append("proProPrice3", getProProPrice3())
            .append("proProPrice4", getProProPrice4())
            .append("proProBelongto", getProProBelongto())
            .append("proCost", getProCost())
            .append("proCostIncludetax", getProCostIncludetax())
            .append("proReverse", getProReverse())
            .append("proProGp1", getProProGp1())
            .append("proProGp2", getProProGp2())
            .append("proProGp3", getProProGp3())
            .append("proProGp4", getProProGp4())
            .append("proFitSubclass", getProFitSubclass())
            .append("proFitEnnomodelno", getProFitEnnomodelno())
            .append("proFitPartnumber", getProFitPartnumber())
            .append("proFitMqq", getProFitMqq())
            .append("proFitPrice", getProFitPrice())
            .append("proFitPriceincludetax", getProFitPriceincludetax())
            .append("proFitNomove", getProFitNomove())
            .append("proFitGp", getProFitGp())
            .append("proFitSupplier", getProFitSupplier())
            .append("proFitSupppartnumber", getProFitSupppartnumber())
            .append("proFitOther", getProFitOther())
            .append("proFitPn", getProFitPn())
            .append("proFitFanprice", getProFitFanprice())
            .append("proFitFanprice1", getProFitFanprice1())
            .append("proFitFancost", getProFitFancost())
            .append("proFitManufacturntax", getProFitManufacturntax())
            .append("proFitCosttax", getProFitCosttax())
            .append("proFitFangp", getProFitFangp())
            .append("proUpdate", getProUpdate())
            .toString();
    }
}
