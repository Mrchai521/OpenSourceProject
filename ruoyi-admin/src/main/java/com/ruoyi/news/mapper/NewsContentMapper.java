package com.ruoyi.news.mapper;

import java.util.List;
import com.ruoyi.news.domain.NewsContent;

/**
 * 新闻内容Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
public interface NewsContentMapper 
{
    /**
     * 查询新闻内容
     * 
     * @param newsContentId 新闻内容ID
     * @return 新闻内容
     */
    public NewsContent selectNewsContentById(Long newsContentId);

    /**
     * 查询新闻内容列表
     * 
     * @param newsContent 新闻内容
     * @return 新闻内容集合
     */
    public List<NewsContent> selectNewsContentList(NewsContent newsContent);

    /**
     * 新增新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    public int insertNewsContent(NewsContent newsContent);

    /**
     * 修改新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    public int updateNewsContent(NewsContent newsContent);

    /**
     * 删除新闻内容
     * 
     * @param newsContentId 新闻内容ID
     * @return 结果
     */
    public int deleteNewsContentById(Long newsContentId);

    /**
     * 批量删除新闻内容
     * 
     * @param newsContentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsContentByIds(String[] newsContentIds);
}
