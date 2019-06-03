package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.entity.CartItem;

import java.util.List;
import java.util.Map;

/**
 * @Author kobe
 * @Date 2019/5/20 20:48
 * @Description: 购物车业务逻辑接口
 * @Modified By:
 */
public interface CartService {
    /**
     * create by: Kobe
     * description:根据Id查询具体购物车
     * create time: 21:17 2019/5/21
     * @param id
     * @return
     */
    Cart findCartById(Integer id);

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
    int addCartItem(Integer userId,Integer bookId,Double subTotal,Integer buyNum);

    /**
     * create by: Kobe
     * description: 删除购物车中的某一项
     * create time: 15:05 2019/5/21
     * @param cartItemId
     * @return
     */
    int removeCartItem(Integer  cartItemId);

    /**
     * create by: Liu Bin
     * description: 分页查看购物车
     * create time: 15:08 2019/6/3
     * @param userId
     * @return
     */
    PageInfo<CartItem> listCart(Integer userId, Integer pageNo, Integer pageSize);

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 21:01 2019/5/21
     * @param userId
     * @return int
     */
    int clearAll(Integer userId);

    /**
     * create by: Kobe
     * description:更新购物项
     * create time: 11:14 2019/5/22
     * @param cartItem
     * @return
     */
    int updateCartItem(CartItem cartItem);

    /**
     * create by: Kobe
     * description:查找具体的购物项
     * create time: 11:20 2019/5/22
     * @param cartItemId
     * @return
     */
    CartItem findCartItemById(Integer  cartItemId);

}
