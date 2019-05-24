package com.scutj2ee.bookstore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 15:20
 * @ Description：邮件工具类
 * @ Modified By：
 */
@Component
public class MailUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * create by: Bin Liu
     * description: 发送文本邮件
     * create time: 2019/4/27 16:30
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            logger.info("简单邮件已发送");
        }catch (Exception e){
            logger.error("发送简单邮件时发生异常！",e);
        }
    }

    /**
     * create by: Bin Liu
     * description: 发送 html 格式邮件
     * create time: 2019/4/27 16:47
     * @Param: null
     * @return
     */
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
        }catch (MessagingException e){
            logger.error("发送html邮件时发生异常！", e);
        }
    }

    /**
     * create by: Bin Liu
     * description: 发送带附件的邮件
     * create time: 2019/4/27 16:47
     * @Param: null
     * @return
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file=new FileSystemResource(new File(filePath));
            String fileName=filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName,file);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        }catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }

    /**
     * create by: Bin Liu
     * description:
     * create time: 2019/4/27 16:47
     * @Param: 发送带静态资源的邮件
     * @return
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res=new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,res);

            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
