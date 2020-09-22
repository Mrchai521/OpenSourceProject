package com.ruoyi.news.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.news.mapper.NewsMenuMapper;
import com.ruoyi.news.domain.NewsMenu;
import com.ruoyi.news.service.INewsMenuService;
import com.ruoyi.common.core.text.Convert;

/**
 * 新闻菜单Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
@Service
public class NewsMenuServiceImpl implements INewsMenuService 
{
    @Autowired
    private NewsMenuMapper newsMenuMapper;

    /**
     * 查询新闻菜单
     * 
     * @param newsMenuId 新闻菜单ID
     * @return 新闻菜单
     */
    @Override
    public NewsMenu selectNewsMenuById(Long newsMenuId)
    {
        return newsMenuMapper.selectNewsMenuById(newsMenuId);
    }

    /**
     * 查询新闻菜单列表
     * 
     * @param newsMenu 新闻菜单
     * @return 新闻菜单
     */
    @Override
    public List<NewsMenu> selectNewsMenuList(NewsMenu newsMenu)
    {
        return newsMenuMapper.selectNewsMenuList(newsMenu);
    }

    /**
     * 新增新闻菜单
     * 
     * @param newsMenu 新闻菜单
     * @return 结果
     */
    @Override
    public int insertNewsMenu(NewsMenu newsMenu)
    {
        return newsMenuMapper.insertNewsMenu(newsMenu);
    }

    /**
     * 修改新闻菜单
     * 
     * @param newsMenu 新闻菜单
     * @return 结果
     */
    @Override
    public int updateNewsMenu(NewsMenu newsMenu)
    {
        return newsMenuMapper.updateNewsMenu(newsMenu);
    }

    /**
     * 删除新闻菜单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsMenuByIds(String ids)
    {
        return newsMenuMapper.deleteNewsMenuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻菜单信息
     * 
     * @param newsMenuId 新闻菜单ID
     * @return 结果
     */
    @Override
    public int deleteNewsMenuById(Long newsMenuId)
    {
        return newsMenuMapper.deleteNewsMenuById(newsMenuId);
    }

    /**
     * 查询新闻菜单树列表
     * 
     * @return 所有新闻菜单信息
     */
    @Override
    public List<Ztree> selectNewsMenuTree()
    {
        List<NewsMenu> newsMenuList = newsMenuMapper.selectNewsMenuList(new NewsMenu());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (NewsMenu newsMenu : newsMenuList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(newsMenu.getNewsMenuId());
            ztree.setpId(newsMenu.getNewsMenuParentId());
            ztree.setName(newsMenu.getNewsMenuName());
            ztree.setTitle(newsMenu.getNewsMenuName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
