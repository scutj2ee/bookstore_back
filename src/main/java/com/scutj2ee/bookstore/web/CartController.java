package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.CartService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

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
     * create by: Liu Bin
     * description:查看该用户id购物车内所有购物项
     * create time: 15:20 2019/6/3
     * @param request,pageNo,pageSize
     * @return 
     */
    @RequestMapping("/list")
    public HashMap<String,Object> listCart(HttpServletRequest request,Integer pageNo, Integer pageSize){
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request, "userId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        //分页获取
        PageInfo<Cart> pageInfo = cartService.listCart(userId,pageNo,pageSize);
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
    public HashMap<String,Object> addToCart(HttpServletRequest request, @RequestParam Integer bookId,@RequestParam Double subTotal,@RequestParam Integer buyNum) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request, "userId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        try {
            int result = cartService.addCart(userId,bookId,subTotal,buyNum);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","添加成功");
            } else{
                resultMap.put("success",false);
                resultMap.put("msg","添加失败");
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
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request, "userId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        try {
            int result = cartService.clearAll(userId);
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
            Integer bookId = HttpServletRequestUtil.getInt(request,"bookId");
            Integer userId = HttpServletRequestUtil.getInt(request,"userId");
            int result = cartService.removeCart(bookId,userId);
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
     * description:更新购物车项
     * create time: 11:11 2019/5/22
     * @param request
     * @return
     */
    @PostMapping("/update")
    public HashMap<String, Object> updateCartItem(HttpServletRequest request,@RequestParam Integer bookId,@RequestParam Double subTotal,@RequestParam Integer buyNum) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request, "userId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        try {
            int result = cartService.updateCart(bookId,userId,subTotal,buyNum);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","修改成功");
            } else{
                resultMap.put("success",false);
                resultMap.put("msg","修改失败");
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
