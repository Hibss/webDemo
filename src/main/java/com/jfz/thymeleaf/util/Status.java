package com.jfz.thymeleaf.util;

import lombok.Getter;

/**
 * @author issac.yu
 * @date 2017/5/16
 * @description
 */
public enum  Status {
    SUCCESS(0),  //成功
    FAILED(1)   //未知失败

    ;

    @Getter
    final Integer code;

    Status(int code) {
        this.code = code;
    }
}
