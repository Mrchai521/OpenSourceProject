package com.ruoyi.news.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.news.mapper.NewsContentMapper;
import com.ruoyi.news.domain.NewsContent;
import com.ruoyi.news.service.INewsContentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 新闻内容Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
@Service
public class NewsContentServiceImpl implements INewsContentService 
{
    @Autowired
    private NewsContentMapper newsContentMapper;

    /**
     * 查询新闻内容
     * 
     * @param newsContentId 新闻内容ID
     * @return 新闻内容
     */
    @Override
    public NewsContent selectNewsContentById(Long newsContentId)
    {
        return newsContentMapper.selectNewsContentById(newsContentId);
    }

    /**
     * 查询新闻内容列表
     * 
     * @param newsContent 新闻内容
     * @return 新闻内容
     */
    @Override
    public List<NewsContent> selectNewsContentList(NewsContent newsContent)
    {
        return newsContentMapper.selectNewsContentList(newsContent);
    }

    /**
     * 新增新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    @Override
    public int insertNewsContent(NewsContent newsContent)
    {
        return newsContentMapper.insertNewsContent(newsContent);
    }

    /**
     * 修改新闻内容
     * 
     * @param newsContent 新闻内容
     * @return 结果
     */
    @Override
    public int updateNewsContent(NewsContent newsContent)
    {
        return newsContentMapper.updateNewsContent(newsContent);
    }

    /**
     * 删除新闻内容对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsContentByIds(String ids)
    {
        return newsContentMapper.deleteNewsContentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻内容信息
     * 
     * @param newsContentId 新闻内容ID
     * @return 结果
     */
    @Override
    public int deleteNewsContentById(Long newsContentId)
    {
        return newsContentMapper.deleteNewsContentById(newsContentId);
    }
}
