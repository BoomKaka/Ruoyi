package com.ruoyi.production.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 规格对象 pro_size
 * 
 * @author SueLiu
 * @date 2020-09-24
 */
public class ProSize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long sizeId;

    /** 型号 */
    @Excel(name = "型号")
    private String sizeModelno;

    /** 简述中文 */
    @Excel(name = "简述中文")
    private String sizeDescribesC;

    /** 简述英文 */
    @Excel(name = "简述英文")
    private String sizeDescribesE;

    /** 简介中文 */
    @Excel(name = "简介中文")
    private String sizeIntroduceC;

    /** 简介英文 */
    @Excel(name = "简介英文")
    private String sizeIntroduceE;

    /** 特性中文 */
    @Excel(name = "特性中文")
    private String sizeCharactorC;

    /** 特性英文 */
    @Excel(name = "特性英文")
    private String sizeCharactorE;

    /** 处理器 */
    @Excel(name = "处理器")
    private String sizeSpecProcessor;

    /** 芯片组 */
    @Excel(name = "芯片组")
    private String sizeSpecChipset;

    /** 内存 */
    @Excel(name = "内存")
    private String sizeSpecMemory;

    /** 存储 */
    @Excel(name = "存储")
    private String sizeSpecStorage;

    /** 显示 */
    @Excel(name = "显示")
    private String sizeSpecDisplay;

    /** 网口 */
    @Excel(name = "网口")
    private String sizeSpecEthernet;

    /** 音频 */
    @Excel(name = "音频")
    private String sizeSpecAudio;

    /** BIOS */
    @Excel(name = "BIOS")
    private String sizeSpecBios;

    /** 外部接口 */
    @Excel(name = "外部接口")
    private String sizeSpecReario;

    /** 内部接口 */
    @Excel(name = "内部接口")
    private String sizeSpecInternalio;

    /** 扩展接口 */
    @Excel(name = "扩展接口")
    private String sizeSpecExpansion;

    /** 环境 */
    @Excel(name = "环境")
    private String sizeSpecEnvironment;

    /** 电源输入 */
    @Excel(name = "电源输入")
    private String sizeSpecPowerinput;

    /** 尺寸 */
    @Excel(name = "尺寸")
    private String sizeSpecDimension;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String sizeSpecOs;

    /** TPM */
    @Excel(name = "TPM")
    private String sizeSpecTpm;

    /** 安全认证 */
    @Excel(name = "安全认证")
    private String sizeSpecSafety;

    /** 配置 */
    @Excel(name = "配置")
    private String sizeConfiguration;

    /** 订购清单 */
    @Excel(name = "订购清单")
    private String sizeOrdering;

    /** 注明中文 */
    @Excel(name = "注明中文")
    private String sizePsC;

    /** 注明英文 */
    @Excel(name = "注明英文")
    private String sizePsE;

    public void setSizeId(Long sizeId) 
    {
        this.sizeId = sizeId;
    }

    public Long getSizeId() 
    {
        return sizeId;
    }
    public void setSizeModelno(String sizeModelno) 
    {
        this.sizeModelno = sizeModelno;
    }

    public String getSizeModelno() 
    {
        return sizeModelno;
    }
    public void setSizeDescribesC(String sizeDescribesC) 
    {
        this.sizeDescribesC = sizeDescribesC;
    }

    public String getSizeDescribesC() 
    {
        return sizeDescribesC;
    }
    public void setSizeDescribesE(String sizeDescribesE) 
    {
        this.sizeDescribesE = sizeDescribesE;
    }

    public String getSizeDescribesE() 
    {
        return sizeDescribesE;
    }
    public void setSizeIntroduceC(String sizeIntroduceC) 
    {
        this.sizeIntroduceC = sizeIntroduceC;
    }

    public String getSizeIntroduceC() 
    {
        return sizeIntroduceC;
    }
    public void setSizeIntroduceE(String sizeIntroduceE) 
    {
        this.sizeIntroduceE = sizeIntroduceE;
    }

    public String getSizeIntroduceE() 
    {
        return sizeIntroduceE;
    }
    public void setSizeCharactorC(String sizeCharactorC) 
    {
        this.sizeCharactorC = sizeCharactorC;
    }

    public String getSizeCharactorC() 
    {
        return sizeCharactorC;
    }
    public void setSizeCharactorE(String sizeCharactorE) 
    {
        this.sizeCharactorE = sizeCharactorE;
    }

    public String getSizeCharactorE() 
    {
        return sizeCharactorE;
    }
    public void setSizeSpecProcessor(String sizeSpecProcessor) 
    {
        this.sizeSpecProcessor = sizeSpecProcessor;
    }

    public String getSizeSpecProcessor() 
    {
        return sizeSpecProcessor;
    }
    public void setSizeSpecChipset(String sizeSpecChipset) 
    {
        this.sizeSpecChipset = sizeSpecChipset;
    }

    public String getSizeSpecChipset() 
    {
        return sizeSpecChipset;
    }
    public void setSizeSpecMemory(String sizeSpecMemory) 
    {
        this.sizeSpecMemory = sizeSpecMemory;
    }

    public String getSizeSpecMemory() 
    {
        return sizeSpecMemory;
    }
    public void setSizeSpecStorage(String sizeSpecStorage) 
    {
        this.sizeSpecStorage = sizeSpecStorage;
    }

    public String getSizeSpecStorage() 
    {
        return sizeSpecStorage;
    }
    public void setSizeSpecDisplay(String sizeSpecDisplay) 
    {
        this.sizeSpecDisplay = sizeSpecDisplay;
    }

    public String getSizeSpecDisplay() 
    {
        return sizeSpecDisplay;
    }
    public void setSizeSpecEthernet(String sizeSpecEthernet) 
    {
        this.sizeSpecEthernet = sizeSpecEthernet;
    }

    public String getSizeSpecEthernet() 
    {
        return sizeSpecEthernet;
    }
    public void setSizeSpecAudio(String sizeSpecAudio) 
    {
        this.sizeSpecAudio = sizeSpecAudio;
    }

    public String getSizeSpecAudio() 
    {
        return sizeSpecAudio;
    }
    public void setSizeSpecBios(String sizeSpecBios) 
    {
        this.sizeSpecBios = sizeSpecBios;
    }

    public String getSizeSpecBios() 
    {
        return sizeSpecBios;
    }
    public void setSizeSpecReario(String sizeSpecReario) 
    {
        this.sizeSpecReario = sizeSpecReario;
    }

    public String getSizeSpecReario() 
    {
        return sizeSpecReario;
    }
    public void setSizeSpecInternalio(String sizeSpecInternalio) 
    {
        this.sizeSpecInternalio = sizeSpecInternalio;
    }

    public String getSizeSpecInternalio() 
    {
        return sizeSpecInternalio;
    }
    public void setSizeSpecExpansion(String sizeSpecExpansion) 
    {
        this.sizeSpecExpansion = sizeSpecExpansion;
    }

    public String getSizeSpecExpansion() 
    {
        return sizeSpecExpansion;
    }
    public void setSizeSpecEnvironment(String sizeSpecEnvironment) 
    {
        this.sizeSpecEnvironment = sizeSpecEnvironment;
    }

    public String getSizeSpecEnvironment() 
    {
        return sizeSpecEnvironment;
    }
    public void setSizeSpecPowerinput(String sizeSpecPowerinput) 
    {
        this.sizeSpecPowerinput = sizeSpecPowerinput;
    }

    public String getSizeSpecPowerinput() 
    {
        return sizeSpecPowerinput;
    }
    public void setSizeSpecDimension(String sizeSpecDimension) 
    {
        this.sizeSpecDimension = sizeSpecDimension;
    }

    public String getSizeSpecDimension() 
    {
        return sizeSpecDimension;
    }
    public void setSizeSpecOs(String sizeSpecOs) 
    {
        this.sizeSpecOs = sizeSpecOs;
    }

    public String getSizeSpecOs() 
    {
        return sizeSpecOs;
    }
    public void setSizeSpecTpm(String sizeSpecTpm) 
    {
        this.sizeSpecTpm = sizeSpecTpm;
    }

    public String getSizeSpecTpm() 
    {
        return sizeSpecTpm;
    }
    public void setSizeSpecSafety(String sizeSpecSafety) 
    {
        this.sizeSpecSafety = sizeSpecSafety;
    }

    public String getSizeSpecSafety() 
    {
        return sizeSpecSafety;
    }
    public void setSizeConfiguration(String sizeConfiguration) 
    {
        this.sizeConfiguration = sizeConfiguration;
    }

    public String getSizeConfiguration() 
    {
        return sizeConfiguration;
    }
    public void setSizeOrdering(String sizeOrdering) 
    {
        this.sizeOrdering = sizeOrdering;
    }

    public String getSizeOrdering() 
    {
        return sizeOrdering;
    }
    public void setSizePsC(String sizePsC) 
    {
        this.sizePsC = sizePsC;
    }

    public String getSizePsC() 
    {
        return sizePsC;
    }
    public void setSizePsE(String sizePsE) 
    {
        this.sizePsE = sizePsE;
    }

    public String getSizePsE() 
    {
        return sizePsE;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sizeId", getSizeId())
            .append("sizeModelno", getSizeModelno())
            .append("sizeDescribesC", getSizeDescribesC())
            .append("sizeDescribesE", getSizeDescribesE())
            .append("sizeIntroduceC", getSizeIntroduceC())
            .append("sizeIntroduceE", getSizeIntroduceE())
            .append("sizeCharactorC", getSizeCharactorC())
            .append("sizeCharactorE", getSizeCharactorE())
            .append("sizeSpecProcessor", getSizeSpecProcessor())
            .append("sizeSpecChipset", getSizeSpecChipset())
            .append("sizeSpecMemory", getSizeSpecMemory())
            .append("sizeSpecStorage", getSizeSpecStorage())
            .append("sizeSpecDisplay", getSizeSpecDisplay())
            .append("sizeSpecEthernet", getSizeSpecEthernet())
            .append("sizeSpecAudio", getSizeSpecAudio())
            .append("sizeSpecBios", getSizeSpecBios())
            .append("sizeSpecReario", getSizeSpecReario())
            .append("sizeSpecInternalio", getSizeSpecInternalio())
            .append("sizeSpecExpansion", getSizeSpecExpansion())
            .append("sizeSpecEnvironment", getSizeSpecEnvironment())
            .append("sizeSpecPowerinput", getSizeSpecPowerinput())
            .append("sizeSpecDimension", getSizeSpecDimension())
            .append("sizeSpecOs", getSizeSpecOs())
            .append("sizeSpecTpm", getSizeSpecTpm())
            .append("sizeSpecSafety", getSizeSpecSafety())
            .append("sizeConfiguration", getSizeConfiguration())
            .append("sizeOrdering", getSizeOrdering())
            .append("sizePsC", getSizePsC())
            .append("sizePsE", getSizePsE())
            .toString();
    }
}
