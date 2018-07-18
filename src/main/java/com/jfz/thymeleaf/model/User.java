package com.jfz.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/15 10:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    // userId
    protected Long userId;

    // 姓名
    protected String fullname;

    // 帐号
    protected String account;

    // 密码
    protected String password;

    // 是否过期
    protected Short isExpired;

    // 是否锁定
    protected Short isLock;

    // 状态
    protected Short status;

    // 邮箱
    protected String email;

    // 手机
    protected String mobile;

    // 电话
    protected String phone;

    // 性别
    protected String sex;

    // 照片
    protected String picture;

    // 入职日期
    protected Date entryDate;

    // 员工状态
    private String userStatus;

    // 员工状态
    private Date quitDate;
    /**
     * 数据来源
     */
    protected short fromType;

    public User setParameter(Map<String, String[]> map) throws Exception{
        Class<? extends User> clazz = this.getClass();
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
