/*
* Copyright (c) 2017 dadeng. All rights reserved.
* Licensed under the Apache License, Version 2.0 (the "License");
*/
package com.jfz.thymeleaf.mapper.cc;

import com.jfz.thymeleaf.model.YTXCallRecord;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author dadeng, 17/3/28
 * @version 1.0, 17/3/28
 */
@Mapper
public interface YTXCallRecordMapper
{
    @Insert("INSERT into ytx_call_record(call_id,status,stime,response,caller,called,downloaded) " +
            "VALUES(#{callId}, #{status},#{stime},#{response},#{caller},#{called},#{downloaded})")
    void insertCallRecord(YTXCallRecord call);

    @Select("select * from ytx_call_record where call_id = #{callId}")
    YTXCallRecord findByCallId(@Param("callId") String callId);

    @Update("update ytx_call_record set utime=#{utime},downloaded=#{downloaded},filename=#{filename}  where call_id=#{callId}")
    void updateDownload(YTXCallRecord call);

    @Select("select * from ytx_call_record where filename is not null and downloaded='false' and utime <#{date} order by id limit 10")
    List<YTXCallRecord> getUnDownloadCallRecord(@Param("date") Date date);

    @Select(value = "select id,\n" +
            "  call_id  callId,\n" + //call_id callId字段对应必须指定
            "     status,\n" +
            "     stime,\n" +
            "     utime,\n" +
            "     response,\n" +
            "     result,\n" +
            "     caller,\n" +
            "     called,\n" +
            "     downloaded,\n" +
            "     filename,\n" +
            "     duration from ytx_call_record where filename is not null and downloaded='false'")
    List<YTXCallRecord> getAllUnDownloadCallRecord();

}
