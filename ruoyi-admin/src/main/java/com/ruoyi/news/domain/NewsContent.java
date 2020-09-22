package com.ruoyi.news.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新闻内容对象 news_content
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
public class NewsContent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long newsContentId;

    /** 新闻标题 */
    @Excel(name = "新闻标题")
    private String newsContentTitle;

    /** 新闻内容 */
    @Excel(name = "新闻内容")
    private String newsContentText;

    /** 所属菜单id */
    @Excel(name = "所属菜单id")
    private Long newsMenuId;

    public void setNewsContentId(Long newsContentId) 
    {
        this.newsContentId = newsContentId;
    }

    public Long getNewsContentId() 
    {
        return newsContentId;
    }
    public void setNewsContentTitle(String newsContentTitle) 
    {
        this.newsContentTitle = newsContentTitle;
    }

    public String getNewsContentTitle() 
    {
        return newsContentTitle;
    }
    public void setNewsContentText(String newsContentText) 
    {
        this.newsContentText = newsContentText;
    }

    public String getNewsContentText() 
    {
        return newsContentText;
    }
    public void setNewsMenuId(Long newsMenuId) 
    {
        this.newsMenuId = newsMenuId;
    }

    public Long getNewsMenuId() 
    {
        return newsMenuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsContentId", getNewsContentId())
            .append("newsContentTitle", getNewsContentTitle())
            .append("newsContentText", getNewsContentText())
            .append("newsMenuId", getNewsMenuId())
            .toString();
    }
}
