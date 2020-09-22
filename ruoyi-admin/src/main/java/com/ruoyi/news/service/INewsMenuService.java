package com.ruoyi.news.service;

import java.util.List;
import com.ruoyi.news.domain.NewsMenu;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 新闻菜单Service接口
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
public interface INewsMenuService 
{
    /**
     * 查询新闻菜单
     * 
     * @param newsMenuId 新闻菜单ID
     * @return 新闻菜单
     */
    public NewsMenu selectNewsMenuById(Long newsMenuId);

    /**
     * 查询新闻菜单列表
     * 
     * @param newsMenu 新闻菜单
     * @return 新闻菜单集合
     */
    public List<NewsMenu> selectNewsMenuList(NewsMenu newsMenu);

    /**
     * 新增新闻菜单
     * 
     * @param newsMenu 新闻菜单
     * @return 结果
     */
    public int insertNewsMenu(NewsMenu newsMenu);

    /**
     * 修改新闻菜单
     * 
     * @param newsMenu 新闻菜单
     * @return 结果
     */
    public int updateNewsMenu(NewsMenu newsMenu);

    /**
     * 批量删除新闻菜单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsMenuByIds(String ids);

    /**
     * 删除新闻菜单信息
     * 
     * @param newsMenuId 新闻菜单ID
     * @return 结果
     */
    public int deleteNewsMenuById(Long newsMenuId);

    /**
     * 查询新闻菜单树列表
     * 
     * @return 所有新闻菜单信息
     */
    public List<Ztree> selectNewsMenuTree();
}
