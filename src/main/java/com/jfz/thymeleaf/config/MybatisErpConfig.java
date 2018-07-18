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
@MapperScan(basePackages = {"com.jfz.thymeleaf.mapper.erp"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisErpConfig {

    @Autowired
    @Qualifier("erpDb")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds1);
        factoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        factoryBean.setConfigLocation(new ClassPathResource("erp-db-config.xml"));
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1());
        return template;
    }
}
