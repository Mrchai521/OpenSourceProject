package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysMail;

/**
 * 邮件Mapper接口
 *
 * @author 柴新峰
 * @date 2020-09-17
 */
public interface SysMailMapper {
    /**
     * 查询邮件
     *
     * @param mailId 邮件ID
     * @return 邮件
     */
    public SysMail selectSysMailById(Integer mailId);

    /**
     * 查询邮件列表
     *
     * @param sysMail 邮件
     * @return 邮件集合
     */
    public List<SysMail> selectSysMailList(SysMail sysMail);

    /**
     * 新增邮件
     *
     * @param sysMail 邮件
     * @return 结果
     */
    public int insertSysMail(SysMail sysMail);

    /**
     * 修改邮件
     *
     * @param sysMail 邮件
     * @return 结果
     */
    public int updateSysMail(SysMail sysMail);

    /**
     * 删除邮件
     *
     * @param mailId 邮件ID
     * @return 结果
     */
    public int deleteSysMailById(Integer mailId);

    /**
     * 批量删除邮件
     *
     * @param mailIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysMailByIds(String[] mailIds);
}
