package com.jfz.thymeleaf.mapper.cc;

import com.jfz.thymeleaf.model.YTXCallBack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author : steven.sheng
 * Description : TODO
 * Date : 2018/3/8 15:32
 */
@Mapper
public interface YTXCallBackMapper {
    @Insert("INSERT into ytx_call_back(info,notify,subject,timestamp,ctime,call_id) " +
            "VALUES(#{info}, #{notify},#{subject},#{timestamp},#{ctime},#{callId})")
    void insertCallBack(YTXCallBack callCallBack);

    @Select("select * from ytx_call_back")
    List<YTXCallBack> getAll();
}
