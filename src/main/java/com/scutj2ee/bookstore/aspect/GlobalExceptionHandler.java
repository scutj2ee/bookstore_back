//package com.scutj2ee.bookstore.aspect;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.logging.Logger;
//
///**
// * @Author kobe
// * @Date 2019/4/25 10:55
// * @Description: 统一异常处理
// * @Modified By:
// */
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    private static final long serialVersionUID = 1L;
//    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    /**
//     * create by: Kobe
//     * description:默认异常处理
//     * create time: 11:02 2019/4/25
//     *
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
//
//    }
//
//}
