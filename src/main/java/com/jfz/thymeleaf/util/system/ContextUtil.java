package com.jfz.thymeleaf.util.system;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/29 15:08
 */
public class ContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String beanId){
        if(StringUtils.isNotEmpty(beanId)){
            return context.getBean(beanId);
        }
        return null;
    }

    public static <C> C getBean(Class<C> classId) {
        if(Objects.nonNull(classId)){
            context.getBean(classId);
        }
        return null;
    }
}
