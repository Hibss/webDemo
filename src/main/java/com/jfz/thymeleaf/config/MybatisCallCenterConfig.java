package com.jfz.thymeleaf.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 17:37
 */
@Configuration
@MapperScan(basePackages = {"com.jfz.thymeleaf.mapper.cc"}, sqlSessionFactoryRef = "sqlSessionFactory0")
public class MybatisCallCenterConfig {

    @Autowired
    @Qualifier("callCenterDb")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory sqlSessionFactory0() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1);
        factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate0() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory0());
        return template;
    }
}
