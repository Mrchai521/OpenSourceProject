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
import com.ruoyi.news.domain.NewsContent;
import com.ruoyi.news.service.INewsContentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻内容Controller
 * 
 * @author ruoyi
 * @date 2020-09-22
 */
@Controller
@RequestMapping("/news/content")
public class NewsContentController extends BaseController
{
    private String prefix = "news/content";

    @Autowired
    private INewsContentService newsContentService;

    @RequiresPermissions("news:content:view")
    @GetMapping()
    public String content()
    {
        return prefix + "/content";
    }

    /**
     * 查询新闻内容列表
     */
    @RequiresPermissions("news:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsContent newsContent)
    {
        startPage();
        List<NewsContent> list = newsContentService.selectNewsContentList(newsContent);
        return getDataTable(list);
    }

    /**
     * 导出新闻内容列表
     */
    @RequiresPermissions("news:content:export")
    @Log(title = "新闻内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsContent newsContent)
    {
        List<NewsContent> list = newsContentService.selectNewsContentList(newsContent);
        ExcelUtil<NewsContent> util = new ExcelUtil<NewsContent>(NewsContent.class);
        return util.exportExcel(list, "content");
    }

    /**
     * 新增新闻内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻内容
     */
    @RequiresPermissions("news:content:add")
    @Log(title = "新闻内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsContent newsContent)
    {
        return toAjax(newsContentService.insertNewsContent(newsContent));
    }

    /**
     * 修改新闻内容
     */
    @GetMapping("/edit/{newsContentId}")
    public String edit(@PathVariable("newsContentId") Long newsContentId, ModelMap mmap)
    {
        NewsContent newsContent = newsContentService.selectNewsContentById(newsContentId);
        mmap.put("newsContent", newsContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻内容
     */
    @RequiresPermissions("news:content:edit")
    @Log(title = "新闻内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsContent newsContent)
    {
        return toAjax(newsContentService.updateNewsContent(newsContent));
    }

    /**
     * 删除新闻内容
     */
    @RequiresPermissions("news:content:remove")
    @Log(title = "新闻内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsContentService.deleteNewsContentByIds(ids));
    }
}
