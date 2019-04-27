package com.scutj2ee.bookstore.service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 16:23
 * @ Description：邮件服务
 * @ Modified By：
 */
public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
