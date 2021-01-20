package com.qhkj.scm.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName DataSourceContextHolder
 * @Description TODO
 * @Author zouwenhai
 * @Date 2020/12/10 22:28
 * @Version 1.0
 */
@Slf4j
public class DataSourceContextHolder {

    //线程安全，存储数据源的key值
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    //设置当前的数据源
    public static void setDatasource(String dbType) {
        log.info("切换到 [ {} ] 数据源", dbType);
        contextHolder.set(dbType);
    }

    //获取当前数据源
    public static String getDatasource() {
        return contextHolder.get();
    }

    //清除当前数据源
    public static void clearDatasource() {
        contextHolder.remove();
    }
}
