package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 邮件对象 sys_mail
 *
 * @author 柴新峰
 * @date 2020-09-17
 */
public class SysMail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 邮件id
     */
    private Integer mailId;

    /**
     * 邮件标题
     */
    @Excel(name = "邮件标题")
    private String mailTitle;

    /**
     * 邮件内容
     */
    @Excel(name = "邮件内容")
    private String mailContent;

    /**
     * 邮件状态（0正常 1关闭）
     */
    @Excel(name = "邮件状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    /**
     * 发送对象
     */
    @Excel(name = "发送对象")
    private String sendObject;

    public void setMailId(Integer mailId) {
        this.mailId = mailId;
    }

    public Integer getMailId() {
        return mailId;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSendObject(String sendObject) {
        this.sendObject = sendObject;
    }

    public String getSendObject() {
        return sendObject;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("mailId", getMailId())
                .append("mailTitle", getMailTitle())
                .append("mailContent", getMailContent())
                .append("status", getStatus())
                .append("sendObject", getSendObject())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
