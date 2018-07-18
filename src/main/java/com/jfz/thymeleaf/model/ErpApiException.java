package com.jfz.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/29 15:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErpApiException implements Serializable{
    // id
    protected Long  id;
    // API异常全名
    protected String  apiExceptionName;
    // API调用的方法名字
    protected String  apiMethodName;
    // API调用来源/全类名
    protected String  apiClassName;
    // API调用来源/类名
    protected String  apiSimpleClassName;
    // API异常产生时间
    protected Long  apiExceptionTime;
    // 产生异常的机器名
    protected String  hostname;
    // 记录创建时间
    protected java.util.Date  createdTime;
    // API异常信息
    protected String  apiExceptionStackTrace;
    // API调用参数
    protected String apiCallArgs;
    //API调用时的登录用户ID
    protected String apiCallerId;

    protected Long  times;
}
