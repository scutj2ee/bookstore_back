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
    Cart findCartById(int id);

    /**
     * create by: Kobe
     * description: 添加商品进购物车
     * create time: 20:54 2019/5/20
     * @param cartItem
     * @return
     */
    int addCartItem(CartItem cartItem);

    /**
     * create by: Kobe
     * description: 删除购物车中的某一项
     * create time: 15:05 2019/5/21
     * @param cartItemId
     * @return
     */
    int removeCartItem(int cartItemId);

    /**
     * create by: Kobe
     * description: 查看购物车
     * create time: 15:08 2019/5/21
     * @param userId
     * @return
     */
    List<CartItem> listCart(int userId);

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 21:01 2019/5/21
     * @param cartId
     * @return int
     */
    int clearAll(int cartId);

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
    CartItem findCartItemById(int cartItemId);

    /**
     * create by: Kobe
     * description:分页获得购物车列表
     * create time: 15:23 2019/5/25
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<CartItem> getCartItemList(Map map, Integer pageNo, Integer pageSize);
}
