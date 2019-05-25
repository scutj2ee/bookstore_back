package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.entity.CartItem;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.service.CartService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author kobe
 * @Date 2019/5/21 15:50
 * @Description: 购物车相关业务
 * @Modified By:
 */

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    
    /**
     * create by: Kobe
     * description:查看该用户id购物车内所有购物项
     * create time: 14:20 2019/5/25
     * @param request,pageNo,pageSize
     * @return 
     */
    @RequestMapping("/list")
    public HashMap<String,Object> listCartItem(HttpServletRequest request,Integer pageNo, Integer pageSize){
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer cartId;
        //获取前端传过来的cartId
        try {
            cartId = HttpServletRequestUtil.getInt(request,"cartId");
        } catch (NumberFormatException e){
            resultMap.put("success",false);
            resultMap.put("msg","获取用户对象ID信息异常！");
            return resultMap;
        }

        Map map = new HashMap();
        map.put("userId",cartId);
        //分页获取
        PageInfo<CartItem> pageInfo = cartService.getCartItemList(map,pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Kobe
     * description:添加商品进购物车
     * create time: 21:10 2019/5/21
     * @param request
     * @return
     */
    @PostMapping("/add")
    public HashMap<String,Object> addToCart(HttpServletRequest request, @RequestBody CartItem cartItem) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            int result = cartService.addCartItem(cartItem);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","成功添加");
            } else{
                resultMap.put("success",false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 23:43 2019/5/21
     * @param request
     * @return
     */
    @DeleteMapping("/clearAll")
    public HashMap<String, Object> clearAll(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            int result = cartService.clearAll(HttpServletRequestUtil.getInt(request,"cartId"));
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","成功清空");
            } else{
                resultMap.put("success",false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Kobe
     * description:删除购物车的某一项
     * create time: 11:08 2019/5/22
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> delCartItem(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            int cartItemId = HttpServletRequestUtil.getInt(request,"cartItemId");
            int result = cartService.removeCartItem(cartItemId);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","成功删除");
            } else{
                resultMap.put("success",false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Kobe
     * description:更新订单
     * create time: 11:11 2019/5/22
     * @param request
     * @return
     */
    @PutMapping("/update")
    public HashMap<String, Object> updateCartItem(HttpServletRequest request, @RequestBody CartItem cartItem) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            int result = cartService.updateCartItem(cartItem);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","成功删除");
            } else{
                resultMap.put("success",false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success",false);
            resultMap.put("code",ex.getCode());
            resultMap.put("msg",ex.getMessage());
            return resultMap;
        }
    }
}
