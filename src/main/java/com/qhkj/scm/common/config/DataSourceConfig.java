//package com.qhkj.scm.common.config;
//
//import com.qhkj.scm.common.enums.DataSourceType;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName DataSourceConfiguration
// * @Description TODO
// * @Author zouwenhai
// * @Date 2020/12/10 23:34
// * @Version 1.0
// */
//@Configuration
//@PropertySource(value = "classpath:jdbc.properties")
//public class DataSourceConfig {
//
//    //数据源1，该数据源连接配置的前缀为spring.datasource.jurisdiction
//    @Bean("dataSourceDb1")
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource dataSource1() {
//        return ;
//    }
//
//    //数据源2，该数据源连接配置的前缀为spring.datasource.base
//    @Bean("dataSourceDb2")
//    @ConfigurationProperties(prefix = "spring.datasource.slaver")
//    public DataSource dataSource2() {
//        return ;
//    }
//
//    //动态数据源
//    @Bean("dynamicDataSource")
//    @Primary//表示优先使用该bean
//    public DataSourceConfig dynamicDataSource() {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        //配置动态数据源的主数据源
//        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
//        //配置动态数据源中使用到的数据源
//        Map<Object, Object> dataSources = new HashMap<>(2);
//        dataSources.put(DataSourceType.MASTER.name(), dataSource1());
//        dataSources.put(DataSourceType.SLAVER.name(), dataSource2());
//        dynamicDataSource.setTargetDataSources(dataSources);
//        return dynamicDataSource;
//    }
//
//    //配置动态使用事务
//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
//        return new DataSourceTransactionManager(dynamicDataSource());
//    }
//}
