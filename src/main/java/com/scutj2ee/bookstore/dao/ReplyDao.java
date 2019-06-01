package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Reply;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 16:19
 * @ Description：${description}
 * @ Modified By：
 */
@Component
public interface ReplyDao {
    int deleteReply(Integer replyId);

    int insertReply(Reply reply);

    Reply findReplyById(Integer replyId);

    List<Reply> selectAll();

    int updateReply(Reply reply);
}
