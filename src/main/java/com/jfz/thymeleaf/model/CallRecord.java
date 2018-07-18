package com.jfz.thymeleaf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.ConvertUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/22 15:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallRecord implements Serializable {
    protected Long id;
    protected Long userId;
    protected String userName;
    protected Long device;
    protected String callPhoneNumber;
    protected String  calledPhoneNumberId;
    protected String callId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    protected java.util.Date callTime;
    protected String callSrcPage;
    protected Long callResponse;
    protected Long isSaveCallRecord;
    protected String businessId;
    protected Short businessType;
    protected String callRecordSrcUrl;
    protected String savedCallRecordUrl;
    protected Integer voiceDuration;
    protected String voiceDurationStr;
    protected Short callType;
    protected Long isDelete;
    protected Long createBy;
    protected Date createtime;
    protected Date updatetime;
    protected Long updateBy;

    public CallRecord setParameter(Map<String, String[]> map) throws Exception{
        Class<? extends CallRecord> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            String fieldName = field.getName();
            if(map.get(fieldName) != null){
                field.set(this, ConvertUtils.convert(map.get(fieldName)[0], field.getType()));
            }
        }
        return this;
    }
}
