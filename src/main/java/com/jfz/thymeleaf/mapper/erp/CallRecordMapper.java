package com.jfz.thymeleaf.mapper.erp;

import com.jfz.thymeleaf.mapper.PageInfo.Page;
import com.jfz.thymeleaf.model.CallRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Objects;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/22 15:14
 */
@Mapper
public interface CallRecordMapper {
    @SelectProvider(type=CallRecordSelectProvider.class,method = "getCount")
    Long getCount(CallRecord record);

    @SelectProvider(type=CallRecordSelectProvider.class,method = "getPageList")
    List<CallRecord> getPageList(Page page, CallRecord record);

    class CallRecordSelectProvider {
        public String getPageList(Page page,CallRecord record){
            String sql = "SELECT * FROM cc_call_record";
            sql += " where 1=1";
            if(!Objects.equals(null,record.getDevice())){
                sql += " and device ="+ record.getDevice()+" ";
            }
            if(!Objects.equals(null,record.getCallType())){
                sql += " and call_type ="+ record.getCallType()+" ";
            }

            if(StringUtils.isNotBlank(record.getUserName())){
                sql += " and user_name regexp '"+ record.getUserName()+"'";
            }

            if(StringUtils.isNotBlank(page.getOrderField())&&StringUtils.isNotBlank(page.getOrderSeq())){
                sql += " order by " ;
                sql += page.getOrderField();
                sql += " ";
                sql += page.getOrderSeq();
                sql += " ";
            }
            sql += " limit ";
            sql += page.getStart();
            sql += " ,";
            sql += page.getLength();
            return sql;
        }

        public String getCount(CallRecord record){
            String sql = "SELECT count(1) FROM cc_call_record";
            sql += " where 1=1";
            if(!Objects.equals(null,record.getDevice())){
                sql += " and device ="+ record.getDevice()+" ";
            }
            if(!Objects.equals(null,record.getCallType())){
                sql += " and call_type ="+ record.getCallType()+" ";
            }

            if(StringUtils.isNotBlank(record.getUserName())){
                sql += " and user_name regexp '"+ record.getUserName()+"'";
            }
            return sql;
        }
    }

}
