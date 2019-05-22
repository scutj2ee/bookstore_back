package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.entity.CartItem;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.service.CartService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author kobe
 * @Date 2019/5/21 15:50
 * @Description: 购物车相关业务
 * @Modified By:
 */
public class CartController {
    @Autowired
    private BookInfoService bookInfoService;

    @Autowired
    private CartService cartService;

    /**
     * create by: Kobe
     * description:添加商品进购物车
     * create time: 21:10 2019/5/21
     * @param request
     * @return
     */
    public void addToCart(HttpServletRequest request){
        Cart cart = cartService.findCartById(Integer.parseInt(HttpServletRequestUtil.getString(request,"cartId")));
        BookInfo bookInfo = bookInfoService.findById(Integer.parseInt(HttpServletRequestUtil.getString(request,"bookId")));

        if(bookInfo != null){
            CartItem cartItem = new CartItem();
            cartItem.setCartId(cart.getId());
            cartItem.setBookId(bookInfo.getBookId());
            cartItem.setBuyNum(Integer.parseInt(HttpServletRequestUtil.getString(request,"buyNum")));
            cartItem.setBookInfo(bookInfo);
            cartItem.setSubTotal(Integer.parseInt(HttpServletRequestUtil.getString(request,"buyNum")));
            cartService.addCartItem(cartItem);
        } else {
            //如果商品库存不足怎么返回信息给前端
            request.getSession().setAttribute("message", "添加失败！");
        }
    }

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 23:43 2019/5/21
     * @param request
     * @return
     */
    public void clearAll(HttpServletRequest request){
        cartService.clearAll(Integer.parseInt(HttpServletRequestUtil.getString(request,"cartId")));
    }

    /**
     * create by: Kobe
     * description:删除购物车的某一项
     * create time: 11:08 2019/5/22
     * @param request
     * @return
     */
    public void delCartItem(HttpServletRequest request){
        cartService.removeCartItem(Integer.parseInt(HttpServletRequestUtil.getString(request,"cartItemId")));
    }

    /**
     * create by: Kobe
     * description:更新订单
     * create time: 11:11 2019/5/22
     * @param request
     * @return
     */
    public void updateCartItem(HttpServletRequest request){
        CartItem cartItem = cartService.findCartItemById(Integer.parseInt(HttpServletRequestUtil.getString(request,"cartItemId")));
        cartItem.setBuyNum(Integer.parseInt(HttpServletRequestUtil.getString(request,"buyNum")));
        cartService.updateCartItem(cartItem);
    }
}
