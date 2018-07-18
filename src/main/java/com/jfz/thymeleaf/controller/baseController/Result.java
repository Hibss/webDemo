package com.jfz.thymeleaf.controller.baseController;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 15:12
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

}
