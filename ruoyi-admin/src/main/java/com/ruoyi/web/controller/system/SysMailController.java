package com.ruoyi.web.controller.system;


import com.ruoyi.system.domain.SysMail;
import com.ruoyi.system.service.ISysMailService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 邮件Controller
 *
 * @author 柴新峰
 * @date 2020-09-17
 */
@Controller
@RequestMapping("/system/mail")
public class SysMailController extends BaseController {
    private String prefix = "system/mail";

    @Autowired
    private ISysMailService sysMailService;

    @RequiresPermissions("system:mail:view")
    @GetMapping()
    public String mail() {
        return prefix + "/mail";
    }

    public AjaxResult sendMail() {
        return null;
    }

    /**
     * 查询邮件列表
     */
    @RequiresPermissions("system:mail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMail sysMail) {
        startPage();
        List<SysMail> list = sysMailService.selectSysMailList(sysMail);
        return getDataTable(list);
    }

    /**
     * 导出邮件列表
     */
    @RequiresPermissions("system:mail:export")
    @Log(title = "邮件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMail sysMail) {
        List<SysMail> list = sysMailService.selectSysMailList(sysMail);
        ExcelUtil<SysMail> util = new ExcelUtil<SysMail>(SysMail.class);
        return util.exportExcel(list, "mail");
    }

    /**
     * 新增邮件
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存邮件
     */
    @RequiresPermissions("system:mail:add")
    @Log(title = "邮件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMail sysMail) {
        return toAjax(sysMailService.insertSysMail(sysMail));
    }

    /**
     * 修改邮件
     */
    @GetMapping("/edit/{mailId}")
    public String edit(@PathVariable("mailId") Integer mailId, ModelMap mmap) {
        SysMail sysMail = sysMailService.selectSysMailById(mailId);
        mmap.put("sysMail", sysMail);
        return prefix + "/edit";
    }

    /**
     * 修改保存邮件
     */
    @RequiresPermissions("system:mail:edit")
    @Log(title = "邮件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMail sysMail) {
        return toAjax(sysMailService.updateSysMail(sysMail));
    }

    /**
     * 删除邮件
     */
    @RequiresPermissions("system:mail:remove")
    @Log(title = "邮件", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysMailService.deleteSysMailByIds(ids));
    }
}
