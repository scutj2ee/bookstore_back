package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartDao {
    int deleteCart(Integer id);

    int insertCart(Cart cart);

    Cart findCartById(Integer id);

    List<Cart> selectAll(Integer userId);

    int updateCart(Cart cart);

    /**
     * create by: Bin Liu
     * description: 清空购物车
     * create time: 2019/6/3 21:18
     * @Param: null
     * @return
     */
    int clearAll(Integer userId);

    /**
     * create by: Bin Liu
     * description: 通过userId和bookId找到购物车项
     * create time: 2019/6/3 21:34
     * @Param: null
     * @return
     */
    Cart findCartByBookIdAndUerId(@Param("bookId")Integer bookId, @Param("userId")Integer userId);

    /**
     * create by: Bin Liu
     * description: 通过userId和bookId删除购物车项
     * create time: 2019/6/3 21:40
     * @Param: null
     * @return
     */
    int deleteCartByUserIdAndBookId(@Param("userId")Integer userId, @Param("bookId") Integer bookId);

    /**
     * @Author Bin Liu
     * @Description 通过购物车id序列找到所有被选中的Cart
     * @Date 2019/6/5 9:21
     * @param cartIds
     * @return
     */
    List<Cart> getCartListParams(List<Integer> cartIds);
}