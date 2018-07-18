package com.jfz.thymeleaf.model;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/22 15:27
 */
public class TransferUtil {



    public static void setParameter(Map<String, String[]> map, Class<CallRecord> callRecordClass, CallRecord record) throws IllegalAccessException {
        Field[] fields = callRecordClass.getDeclaredFields();
        for(Field field:fields){
            String fieldName = field.getName();
            if(map.get(fieldName) != null){
                field.set(record, ConvertUtils.convert(map.get(fieldName)[0], field.getType()));
            }
        }

    }
}
