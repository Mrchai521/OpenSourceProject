package com.ruoyi.news.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.news.domain.NewsMenu;
import com.ruoyi.news.service.INewsMenuService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 新闻菜单Controller
 * 
 * @author 柴新峰
 * @date 2020-09-22
 */
@Controller
@RequestMapping("/news/menu")
public class NewsMenuController extends BaseController
{
    private String prefix = "news/menu";

    @Autowired
    private INewsMenuService newsMenuService;

    @RequiresPermissions("news:menu:view")
    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    /**
     * 查询新闻菜单树列表
     */
    @RequiresPermissions("news:menu:list")
    @PostMapping("/list")
    @ResponseBody
    public List<NewsMenu> list(NewsMenu newsMenu)
    {
        List<NewsMenu> list = newsMenuService.selectNewsMenuList(newsMenu);
        return list;
    }

    /**
     * 导出新闻菜单列表
     */
    @RequiresPermissions("news:menu:export")
    @Log(title = "新闻菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsMenu newsMenu)
    {
        List<NewsMenu> list = newsMenuService.selectNewsMenuList(newsMenu);
        ExcelUtil<NewsMenu> util = new ExcelUtil<NewsMenu>(NewsMenu.class);
        return util.exportExcel(list, "menu");
    }

    /**
     * 新增新闻菜单
     */
    @GetMapping(value = { "/add/{newsMenuId}", "/add/" })
    public String add(@PathVariable(value = "newsMenuId", required = false) Long newsMenuId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(newsMenuId))
        {
            mmap.put("newsMenu", newsMenuService.selectNewsMenuById(newsMenuId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存新闻菜单
     */
    @RequiresPermissions("news:menu:add")
    @Log(title = "新闻菜单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsMenu newsMenu)
    {
        return toAjax(newsMenuService.insertNewsMenu(newsMenu));
    }

    /**
     * 修改新闻菜单
     */
    @GetMapping("/edit/{newsMenuId}")
    public String edit(@PathVariable("newsMenuId") Long newsMenuId, ModelMap mmap)
    {
        NewsMenu newsMenu = newsMenuService.selectNewsMenuById(newsMenuId);
        mmap.put("newsMenu", newsMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻菜单
     */
    @RequiresPermissions("news:menu:edit")
    @Log(title = "新闻菜单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsMenu newsMenu)
    {
        return toAjax(newsMenuService.updateNewsMenu(newsMenu));
    }

    /**
     * 删除
     */
    @RequiresPermissions("news:menu:remove")
    @Log(title = "新闻菜单", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{newsMenuId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("newsMenuId") Long newsMenuId)
    {
        return toAjax(newsMenuService.deleteNewsMenuById(newsMenuId));
    }

    /**
     * 选择新闻菜单树
     */
    @GetMapping(value = { "/selectMenuTree/{newsMenuId}", "/selectMenuTree/" })
    public String selectMenuTree(@PathVariable(value = "newsMenuId", required = false) Long newsMenuId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(newsMenuId))
        {
            mmap.put("newsMenu", newsMenuService.selectNewsMenuById(newsMenuId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载新闻菜单树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = newsMenuService.selectNewsMenuTree();
        return ztrees;
    }
}
