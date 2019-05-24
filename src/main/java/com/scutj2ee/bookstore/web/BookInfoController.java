package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.service.AddressService;
import com.scutj2ee.bookstore.service.BookCategoryService;
import com.scutj2ee.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: kevin
 * @data: 2019/5/17 12:47
 * @description:
 */
@RequestMapping("/book")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private AddressService addressService;



}
