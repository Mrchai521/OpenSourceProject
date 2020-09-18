package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMailMapper;
import com.ruoyi.system.domain.SysMail;
import com.ruoyi.system.service.ISysMailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 邮件Service业务层处理
 *
 * @author 柴新峰
 * @date 2020-09-17
 */
@Service
public class SysMailServiceImpl implements ISysMailService {
    @Autowired
    private SysMailMapper sysMailMapper;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    /**
     * 查询邮件
     *
     * @param mailId 邮件ID
     * @return 邮件
     */
    @Override
    public SysMail selectSysMailById(Integer mailId) {
        return sysMailMapper.selectSysMailById(mailId);
    }

    /**
     * 查询邮件列表
     *
     * @param sysMail 邮件
     * @return 邮件
     */
    @Override
    public List<SysMail> selectSysMailList(SysMail sysMail) {
        return sysMailMapper.selectSysMailList(sysMail);
    }

    /**
     * 新增邮件
     *
     * @param sysMail 邮件
     * @return 结果
     */
    @Override
    public int insertSysMail(SysMail sysMail) {
        sysMail.setCreateTime(DateUtils.getNowDate());
        return sysMailMapper.insertSysMail(sysMail);
    }

    /**
     * 修改邮件
     *
     * @param sysMail 邮件
     * @return 结果
     */
    @Override
    public int updateSysMail(SysMail sysMail) {
        sysMail.setUpdateTime(DateUtils.getNowDate());
        return sysMailMapper.updateSysMail(sysMail);
    }

    /**
     * 删除邮件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysMailByIds(String ids) {
        return sysMailMapper.deleteSysMailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除邮件信息
     *
     * @param mailId 邮件ID
     * @return 结果
     */
    @Override
    public int deleteSysMailById(Integer mailId) {
        return sysMailMapper.deleteSysMailById(mailId);
    }

    /**
     * 获取邮件发信人
     */
    public String getMailSendFrom() {
        return javaMailSenderImpl.getJavaMailProperties().getProperty("from");
    }

    @Override
    public String sendMail(SysMail sysMail) {
        try {
            // true表示复杂类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true);
            //邮件发送人
            mimeMessageHelper.setFrom(getMailSendFrom());
            // 邮件收信人
            mimeMessageHelper.setTo(sysMail.getSendObject());
            //邮件主题
            mimeMessageHelper.setSubject(sysMail.getMailTitle());
            // 邮件内容
            mimeMessageHelper.setText(sysMail.getMailContent(),true);
            //正式发送邮件
            javaMailSender.send(mimeMessageHelper.getMimeMessage());
            return "发送成功！";
        } catch (Exception e) {
            return "发送失败";
        }
    }
}
