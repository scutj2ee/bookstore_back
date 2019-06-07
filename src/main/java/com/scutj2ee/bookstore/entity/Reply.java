package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：回复实体类
 * @ Modified By：
 */
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 回复目标id
     * 如果reply_type是comment的话，那么reply_id＝commit_id，
     * 如果reply_type是reply的话，这表示这条回复的父回复。
     */
    private Integer replyId;
    /**
     * 回复类型：针对评论的回复(comment)为1，针对回复的回复(reply)为2
     */
    private Integer replyType;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 回复用户id
     */
    private Integer fromUid;
    /**
     * 目标用户id
     */
    private Integer toUid;

    /**
     * 回复时间
     */
    private Date date;

    public Reply(){

    }

    public Reply(Integer id, Integer commentId, Integer replyId, Integer replyType, String content, Integer fromUid, Integer toUid, Date date) {
        this.id = id;
        this.commentId = commentId;
        this.replyId = replyId;
        this.replyType = replyType;
        this.content = content;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public Integer getToUid() {
        return toUid;
    }

    public void setToUid(Integer toUid) {
        this.toUid = toUid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", commentId=" + commentId +
                ", replyId=" + replyId +
                ", replyType='" + replyType + '\'' +
                ", content='" + content + '\'' +
                ", fromUid=" + fromUid +
                ", toUid=" + toUid +
                ", date=" + date +
                '}';
    }
}
