package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookCategoryDao;
import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.dao.CommentDao;
import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.model.dto.BookInfoDto;
import com.scutj2ee.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/16 22:41
 * @description:
 */
@Service
public class BookInfoServiceImple implements BookInfoService {
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private BookCategoryDao bookCategoryDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;

    @Override
    public BookInfoDto findById(Integer id) {
        BookInfoDto bookInfoDto=new BookInfoDto();
        bookInfoDto.setBookInfo(bookInfoDao.findBookInfoById(id));
        List<Comment> commentList=commentDao.getCommentListByBookId(id);
        for(Comment comment:commentList){
            comment.setUser(userDao.findUserById(comment.getFromUid()));
        }
        bookInfoDto.setCommentList(commentList);
        return bookInfoDto;
    }

    @Override
    public PageInfo<BookInfo> findByBookCategoryId(Integer bookCategoryId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        //找出所有一级类目的二级类目集合
        List<BookCategory> bookCategoryList=bookCategoryDao.findByParentId(bookCategoryId);
        List<Integer> bookCategorySecondIdList=new ArrayList<>();
        for(BookCategory bookCategory:bookCategoryList){
            bookCategorySecondIdList.add(bookCategory.getId());
        }
        List<BookInfo> bookInfoLists=bookInfoDao.getBookListParams(bookCategorySecondIdList);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(bookInfoLists);
        return pageInfo;
    }

    @Override
    public PageInfo<BookInfo> findByBookCategoryIdSecond(Integer bookCategoryId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> bookInfoLists = bookInfoDao.findByBookCategoryId(bookCategoryId);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(bookInfoLists);
        return pageInfo;
    }

    @Override
    public PageInfo<BookInfo> findNewBook(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> newBooks = bookInfoDao.findNew();
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(newBooks);
        return pageInfo;
    }

    @Override
    public int update(BookInfo bookInfo) {
        return bookInfoDao.updateBookInfo(bookInfo);
    }

    @Override
    public int create(BookInfo bookInfo) {
        return bookInfoDao.insertBookInfo(bookInfo);
    }

    @Override
    public int deleteById(Integer id) {
        return bookInfoDao.deleteBookInfo(id);
    }

    @Override
    public PageInfo<BookInfo> getBookInfoList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> bookInfoList = bookInfoDao.selectAll();
        for(BookInfo bookInfo:bookInfoList){
            //创建书本传输类
            BookInfoDto bookInfoDto=new BookInfoDto();
            //获取书本信息
            BookCategory bookCategory=bookCategoryDao.findBookCategoryById(bookInfo.getBookCategoryId());
            bookInfo.setBookCategory(bookCategory);
            bookInfoDto.setBookInfo(bookInfo);
        }
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(bookInfoList);
        return pageInfo;
    }
}
