//package com.qhkj.scm.common.config;
//
//import com.qhkj.scm.common.DataSourceContextHolder;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.utils.Map;
//
///**
// * @ClassName DynamicDataSource
// * @Description TODO
// * @Author zouwenhai
// * @Date 2020/12/10 23:42
// * @Version 1.0
// */
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
//        super.setDefaultTargetDataSource(defaultTargetDataSource);
//        super.setTargetDataSources(targetDataSources);
//        super.afterPropertiesSet();
//    }
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//
//        return DataSourceContextHolder.getDatasource();
//    }
//}
