package com.jfz.thymeleaf.controller.baseController;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 15:13
 */
public enum  ResultCode {

    WEAK_NET_WORK(-2, "网络异常"),
    SUCCESS(0, "请求成功"),
    WARN(-1, "网络异常，请稍后重试");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
