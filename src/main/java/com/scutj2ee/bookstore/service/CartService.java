package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Cart;

/**
 * @Author kobe
 * @Date 2019/5/20 20:48
 * @Description: 购物车业务逻辑接口
 * @Modified By:
 */
public interface CartService {
    /**
     * create by: Kobe
     * description: 添加商品进购物车
     * create time: 20:54 2019/5/20
     * @param userId
     * @param bookId
     * @param subTotal
     * @param buyNum
     * @return
     */
    int addCart(Integer userId,Integer bookId,Double subTotal,Integer buyNum);

    /**
     * create by: Kobe
     * description: 删除购物车中的某一项
     * create time: 15:05 2019/5/21
     * @param userId
     * @param bookId
     * @return
     */
    int removeCart(Integer  userId,Integer bookId);

    /**
     * create by: Liu Bin
     * description: 分页查看购物车
     * create time: 15:08 2019/6/3
     * @param userId
     * @return
     */
    PageInfo<Cart> listCart(Integer userId, Integer pageNo, Integer pageSize);

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 21:01 2019/5/21
     * @param userId
     * @return int
     */
    int clearAll(Integer userId);

    /**
    * create by: Bin Liu
    * description: 更新购物项
    * create time: 2019/6/3 21:45
    * @Param: userId
    * @param: bookId
    * @param subTotal
    * @param buyNum
    * @return
    */
    int updateCart(Integer userId,Integer bookId,Double subTotal,Integer buyNum);

}
