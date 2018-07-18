package com.jfz.thymeleaf.controller.baseController;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 15:07
 */
public class BaseController {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return new Result(ResultCode.WEAK_NET_WORK);
    }

}
