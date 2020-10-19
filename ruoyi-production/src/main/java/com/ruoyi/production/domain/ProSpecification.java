package com.ruoyi.production.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规格表对象 pro_specification
 * 
 * @author SueLiu
 * @date 2020-10-09
 */
public class ProSpecification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规格ID */
    private Long specId;

    /** 型号 */
    @Excel(name = "分类")
    private String specClass;

    /** 型号 */
    @Excel(name = "型号")
    private String specModelno;

    /** 简述中文 */
    @Excel(name = "简述中文")
    private String specDescribesC;

    /** 简述英文 */
    @Excel(name = "简述英文")
    private String specDescribesE;

    /** 简介中文 */
    @Excel(name = "简介中文")
    private String specIntroduceC;

    /** 简介英文 */
    @Excel(name = "简介英文")
    private String specIntroduceE;

    /** 特性中文 */
    @Excel(name = "特性中文")
    private String specCharactorC;

    /** 特性英文 */
    @Excel(name = "特性英文")
    private String specCharactorE;

    /** 处理器 */
    @Excel(name = "处理器")
    private String specSpecProcessor;

    /** 芯片组 */
    @Excel(name = "芯片组")
    private String specSpecChipset;

    /** 内存 */
    @Excel(name = "内存")
    private String specSpecMemory;

    /** 存储 */
    @Excel(name = "存储")
    private String specSpecStorage;

    /** 显示屏 */
    @Excel(name = "显示屏")
    private String specSpecDisplay;

    /** 网口 */
    @Excel(name = "网口")
    private String specSpecEthernet;

    /** 音频 */
    @Excel(name = "音频")
    private String specSpecAudio;

    /** BIOS */
    @Excel(name = "BIOS")
    private String specSpecBios;

    /** 外部接口 */
    @Excel(name = "外部接口")
    private String specSpecExternalio;

    /** 内部接口 */
    @Excel(name = "内部接口")
    private String specSpecInternalio;

    /** 扩展接口 */
    @Excel(name = "扩展接口")
    private String specSpecExpansion;

    /** 环境 */
    @Excel(name = "环境")
    private String specSpecEnvironment;

    /** 电源 */
    @Excel(name = "电源")
    private String specSpecPower;

    /** 尺寸 */
    @Excel(name = "尺寸")
    private String specSpecDimension;

    /** TPM */
    @Excel(name = "TPM")
    private String specSpecTpm;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String specSpecOs;

    /** 系统 */
    @Excel(name = "系统")
    private String specSpecSystem;

    /** 机构 */
    @Excel(name = "机构")
    private String specSpecMechanical;

    /** 触摸屏 */
    @Excel(name = "触摸屏")
    private String specSpecTouchscreen;

    /** CEA特有 */
    @Excel(name = "CEA特有")
    private String specSpecCea;

    /** 安全认证 */
    @Excel(name = "安全认证")
    private String specSpecSafety;

    /** 配置 */
    @Excel(name = "配置")
    private String specConfiguration;

    /** 订购清单 */
    @Excel(name = "订购清单")
    private String specOrdering;

    /** 注明中文 */
    @Excel(name = "注明中文")
    private String specPsC;

    /** 注明英文 */
    @Excel(name = "注明英文")
    private String specPsE;

    public ProSpecification() {
    }

    public void setSpecId(Long specId) 
    {
        this.specId = specId;
    }

    public Long getSpecId() 
    {
        return specId;
    }
    public String getSpecClass() {
        return specClass;
    }

    public void setSpecClass(String specClass) {
        this.specClass = specClass;
    }
    public void setSpecModelno(String specModelno) 
    {
        this.specModelno = specModelno;
    }

    public String getSpecModelno() 
    {
        return specModelno;
    }
    public void setSpecDescribesC(String specDescribesC)
    {
        this.specDescribesC = specDescribesC;
    }

    public String getSpecDescribesC()
    {
        return specDescribesC;
    }
    public void setSpecDescribesE(String specDescribesE) 
    {
        this.specDescribesE = specDescribesE;
    }

    public String getSpecDescribesE() 
    {
        return specDescribesE;
    }
    public void setSpecIntroduceC(String specIntroduceC) 
    {
        this.specIntroduceC = specIntroduceC;
    }

    public String getSpecIntroduceC() 
    {
        return specIntroduceC;
    }
    public void setSpecIntroduceE(String specIntroduceE) 
    {
        this.specIntroduceE = specIntroduceE;
    }

    public String getSpecIntroduceE() 
    {
        return specIntroduceE;
    }
    public void setSpecCharactorC(String specCharactorC) 
    {
        this.specCharactorC = specCharactorC;
    }

    public String getSpecCharactorC() 
    {
        return specCharactorC;
    }
    public void setSpecCharactorE(String specCharactorE) 
    {
        this.specCharactorE = specCharactorE;
    }

    public String getSpecCharactorE() 
    {
        return specCharactorE;
    }
    public void setSpecSpecProcessor(String specSpecProcessor) 
    {
        this.specSpecProcessor = specSpecProcessor;
    }

    public String getSpecSpecProcessor() 
    {
        return specSpecProcessor;
    }
    public void setSpecSpecChipset(String specSpecChipset) 
    {
        this.specSpecChipset = specSpecChipset;
    }

    public String getSpecSpecChipset() 
    {
        return specSpecChipset;
    }
    public void setSpecSpecMemory(String specSpecMemory) 
    {
        this.specSpecMemory = specSpecMemory;
    }

    public String getSpecSpecMemory() 
    {
        return specSpecMemory;
    }
    public void setSpecSpecStorage(String specSpecStorage) 
    {
        this.specSpecStorage = specSpecStorage;
    }

    public String getSpecSpecStorage() 
    {
        return specSpecStorage;
    }
    public void setSpecSpecDisplay(String specSpecDisplay) 
    {
        this.specSpecDisplay = specSpecDisplay;
    }

    public String getSpecSpecDisplay() 
    {
        return specSpecDisplay;
    }
    public void setSpecSpecEthernet(String specSpecEthernet) 
    {
        this.specSpecEthernet = specSpecEthernet;
    }

    public String getSpecSpecEthernet() 
    {
        return specSpecEthernet;
    }
    public void setSpecSpecAudio(String specSpecAudio) 
    {
        this.specSpecAudio = specSpecAudio;
    }

    public String getSpecSpecAudio() 
    {
        return specSpecAudio;
    }
    public void setSpecSpecBios(String specSpecBios) 
    {
        this.specSpecBios = specSpecBios;
    }

    public String getSpecSpecBios() 
    {
        return specSpecBios;
    }
    public void setSpecSpecExternalio(String specSpecExternalio) 
    {
        this.specSpecExternalio = specSpecExternalio;
    }

    public String getSpecSpecExternalio() 
    {
        return specSpecExternalio;
    }
    public void setSpecSpecInternalio(String specSpecInternalio) 
    {
        this.specSpecInternalio = specSpecInternalio;
    }

    public String getSpecSpecInternalio() 
    {
        return specSpecInternalio;
    }
    public void setSpecSpecExpansion(String specSpecExpansion) 
    {
        this.specSpecExpansion = specSpecExpansion;
    }

    public String getSpecSpecExpansion() 
    {
        return specSpecExpansion;
    }
    public void setSpecSpecEnvironment(String specSpecEnvironment) 
    {
        this.specSpecEnvironment = specSpecEnvironment;
    }

    public String getSpecSpecEnvironment() 
    {
        return specSpecEnvironment;
    }
    public void setSpecSpecPower(String specSpecPower) 
    {
        this.specSpecPower = specSpecPower;
    }

    public String getSpecSpecPower() 
    {
        return specSpecPower;
    }
    public void setSpecSpecDimension(String specSpecDimension) 
    {
        this.specSpecDimension = specSpecDimension;
    }

    public String getSpecSpecDimension() 
    {
        return specSpecDimension;
    }
    public void setSpecSpecTpm(String specSpecTpm) 
    {
        this.specSpecTpm = specSpecTpm;
    }

    public String getSpecSpecTpm() 
    {
        return specSpecTpm;
    }
    public void setSpecSpecOs(String specSpecOs) 
    {
        this.specSpecOs = specSpecOs;
    }

    public String getSpecSpecOs() 
    {
        return specSpecOs;
    }
    public void setSpecSpecSystem(String specSpecSystem) 
    {
        this.specSpecSystem = specSpecSystem;
    }

    public String getSpecSpecSystem() 
    {
        return specSpecSystem;
    }
    public void setSpecSpecMechanical(String specSpecMechanical) 
    {
        this.specSpecMechanical = specSpecMechanical;
    }

    public String getSpecSpecMechanical() 
    {
        return specSpecMechanical;
    }
    public void setSpecSpecTouchscreen(String specSpecTouchscreen) 
    {
        this.specSpecTouchscreen = specSpecTouchscreen;
    }

    public String getSpecSpecTouchscreen() 
    {
        return specSpecTouchscreen;
    }
    public void setSpecSpecCea(String specSpecCea) 
    {
        this.specSpecCea = specSpecCea;
    }

    public String getSpecSpecCea() 
    {
        return specSpecCea;
    }
    public void setSpecSpecSafety(String specSpecSafety) 
    {
        this.specSpecSafety = specSpecSafety;
    }

    public String getSpecSpecSafety() 
    {
        return specSpecSafety;
    }
    public void setSpecConfiguration(String specConfiguration) 
    {
        this.specConfiguration = specConfiguration;
    }

    public String getSpecConfiguration() 
    {
        return specConfiguration;
    }
    public void setSpecOrdering(String specOrdering) 
    {
        this.specOrdering = specOrdering;
    }

    public String getSpecOrdering() 
    {
        return specOrdering;
    }
    public void setSpecPsC(String specPsC) 
    {
        this.specPsC = specPsC;
    }

    public String getSpecPsC() 
    {
        return specPsC;
    }
    public void setSpecPsE(String specPsE) 
    {
        this.specPsE = specPsE;
    }

    public String getSpecPsE() 
    {
        return specPsE;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("specId", getSpecId())
            .append("specClass",getSpecClass())
            .append("specModelno", getSpecModelno())
            .append("specDescribesC", getSpecDescribesC())
            .append("specDescribesE", getSpecDescribesE())
            .append("specIntroduceC", getSpecIntroduceC())
            .append("specIntroduceE", getSpecIntroduceE())
            .append("specCharactorC", getSpecCharactorC())
            .append("specCharactorE", getSpecCharactorE())
            .append("specSpecProcessor", getSpecSpecProcessor())
            .append("specSpecChipset", getSpecSpecChipset())
            .append("specSpecMemory", getSpecSpecMemory())
            .append("specSpecStorage", getSpecSpecStorage())
            .append("specSpecDisplay", getSpecSpecDisplay())
            .append("specSpecEthernet", getSpecSpecEthernet())
            .append("specSpecAudio", getSpecSpecAudio())
            .append("specSpecBios", getSpecSpecBios())
            .append("specSpecExternalio", getSpecSpecExternalio())
            .append("specSpecInternalio", getSpecSpecInternalio())
            .append("specSpecExpansion", getSpecSpecExpansion())
            .append("specSpecEnvironment", getSpecSpecEnvironment())
            .append("specSpecPower", getSpecSpecPower())
            .append("specSpecDimension", getSpecSpecDimension())
            .append("specSpecTpm", getSpecSpecTpm())
            .append("specSpecOs", getSpecSpecOs())
            .append("specSpecSystem", getSpecSpecSystem())
            .append("specSpecMechanical", getSpecSpecMechanical())
            .append("specSpecTouchscreen", getSpecSpecTouchscreen())
            .append("specSpecCea", getSpecSpecCea())
            .append("specSpecSafety", getSpecSpecSafety())
            .append("specConfiguration", getSpecConfiguration())
            .append("specOrdering", getSpecOrdering())
            .append("specPsC", getSpecPsC())
            .append("specPsE", getSpecPsE())
            .toString();
    }


}
