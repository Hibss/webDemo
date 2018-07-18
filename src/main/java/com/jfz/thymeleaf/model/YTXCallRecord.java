package com.jfz.thymeleaf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/3/6 13:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YTXCallRecord {
    protected Long id;
    protected String callId;
    protected String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date stime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected Date utime;
    protected String response;
    protected String result;
    protected String caller;
    protected String called;
    protected String downloaded;
    protected String filename;
    protected Integer duration;
}
