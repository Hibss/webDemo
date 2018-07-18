package com.jfz.thymeleaf.util;

import lombok.Getter;

/**
 * @author issac.yu
 * @date 2017/5/16
 * @description
 */
public enum Errors
{
    ILLEGAL_PARAMETER(100), // 参数错误
    MONTH_FORMAT_ERROR(101), // 月份格式错误
    UNKNOWN_PRODUCT_TYPE(102), // 未知产品类型
    UN_FOUND_UID(103), // 无法找到UID
    UN_FOUND_WAREHOUSE(104), // 无法找到持仓
    SYSTEM_EXCEPTION(105), // 系统错误
    NOT_PERMISSION(106) // 没有权限
    ;
    
    @Getter
    final Integer code;
    
    Errors(int code)
    {
        this.code = code;
    }
}
