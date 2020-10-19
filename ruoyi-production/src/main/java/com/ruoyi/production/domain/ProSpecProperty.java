package com.ruoyi.production.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 规格属性对象 pro_spec_property
 * 
 * @author Jonie
 * @date 2020-10-09
 */
public class ProSpecProperty extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long specpId;

    /** 名称 */
    @Excel(name = "名称")
    private String specpName;

    /** 父节点 */
    @Excel(name = "父节点")
    private Long specpParentid;

    /** 排序 */
    @Excel(name = "排序")
    private Integer specpOrdernum;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private String specpUnable;

    /** 创建者 */
    @Excel(name = "创建者")
    private String specpCreator;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date specpCreattime;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date specpUpdatatime;

    public void setSpecpId(Long specpId) 
    {
        this.specpId = specpId;
    }

    public Long getSpecpId() 
    {
        return specpId;
    }
    public void setSpecpName(String specpName) 
    {
        this.specpName = specpName;
    }

    public String getSpecpName() 
    {
        return specpName;
    }
    public void setSpecpParentid(Long specpParentid)
    {
        this.specpParentid = specpParentid;
    }

    public Long getSpecpParentid()
    {
        return specpParentid;
    }
    public void setSpecpOrdernum(Integer specpOrdernum) 
    {
        this.specpOrdernum = specpOrdernum;
    }

    public Integer getSpecpOrdernum() 
    {
        return specpOrdernum;
    }
    public void setSpecpUnable(String specpUnable) 
    {
        this.specpUnable = specpUnable;
    }

    public String getSpecpUnable() 
    {
        return specpUnable;
    }
    public void setSpecpCreator(String specpCreator) 
    {
        this.specpCreator = specpCreator;
    }

    public String getSpecpCreator() 
    {
        return specpCreator;
    }
    public void setSpecpCreattime(Date specpCreattime) 
    {
        this.specpCreattime = specpCreattime;
    }

    public Date getSpecpCreattime() 
    {
        return specpCreattime;
    }
    public void setSpecpUpdatatime(Date specpUpdatatime) 
    {
        this.specpUpdatatime = specpUpdatatime;
    }

    public Date getSpecpUpdatatime() 
    {
        return specpUpdatatime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("specpId", getSpecpId())
            .append("specpName", getSpecpName())
            .append("specpParentid", getSpecpParentid())
            .append("specpOrdernum", getSpecpOrdernum())
            .append("specpUnable", getSpecpUnable())
            .append("specpCreator", getSpecpCreator())
            .append("specpCreattime", getSpecpCreattime())
            .append("specpUpdatatime", getSpecpUpdatatime())
            .toString();
    }
}
