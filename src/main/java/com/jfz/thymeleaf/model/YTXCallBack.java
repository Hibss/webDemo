package com.jfz.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/3/8 15:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YTXCallBack {
    protected Long id;
    protected String info;
    protected String subject;
    protected String notify;
    protected String timestamp;
    protected Date ctime;
    protected String callId;
}
