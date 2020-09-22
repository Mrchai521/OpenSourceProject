package com.ruoyi.news.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 新闻菜单对象 news_menu
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
public class NewsMenu extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long newsMenuId;

    /** 父id */
    @Excel(name = "父id")
    private Long newsMenuParentId;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String newsMenuName;

    /** 菜单类型 */
    @Excel(name = "菜单类型")
    private String newsMenuType;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String newsMenuIcon;

    /** 显示 */
    @Excel(name = "显示")
    private String newsMenuVisibel;

    public void setNewsMenuId(Long newsMenuId) 
    {
        this.newsMenuId = newsMenuId;
    }

    public Long getNewsMenuId() 
    {
        return newsMenuId;
    }
    public void setNewsMenuParentId(Long newsMenuParentId) 
    {
        this.newsMenuParentId = newsMenuParentId;
    }

    public Long getNewsMenuParentId() 
    {
        return newsMenuParentId;
    }
    public void setNewsMenuName(String newsMenuName) 
    {
        this.newsMenuName = newsMenuName;
    }

    public String getNewsMenuName() 
    {
        return newsMenuName;
    }
    public void setNewsMenuType(String newsMenuType) 
    {
        this.newsMenuType = newsMenuType;
    }

    public String getNewsMenuType() 
    {
        return newsMenuType;
    }
    public void setNewsMenuIcon(String newsMenuIcon) 
    {
        this.newsMenuIcon = newsMenuIcon;
    }

    public String getNewsMenuIcon() 
    {
        return newsMenuIcon;
    }
    public void setNewsMenuVisibel(String newsMenuVisibel) 
    {
        this.newsMenuVisibel = newsMenuVisibel;
    }

    public String getNewsMenuVisibel() 
    {
        return newsMenuVisibel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsMenuId", getNewsMenuId())
            .append("newsMenuParentId", getNewsMenuParentId())
            .append("newsMenuName", getNewsMenuName())
            .append("newsMenuType", getNewsMenuType())
            .append("newsMenuIcon", getNewsMenuIcon())
            .append("newsMenuVisibel", getNewsMenuVisibel())
            .toString();
    }
}
