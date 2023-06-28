package com.naver.config;

import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {
//    private final DataSource dataSource;
//
//    public MybatisConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public SqlSessionFactoryBean sessionFactoryBean(){
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setMapperLocations(
//                new FileSystemResource("classpath:/sqlMap/*.xml"));
//        sessionFactoryBean.setConfigLocation(
//                new FileSystemResource("classpath:/config/mybatisConfig.xml"));
//        return  sessionFactoryBean;
//    }
}
