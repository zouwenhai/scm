//package com.qhkj.scm.common.config;
//
//import com.qhkj.scm.common.DataSourceContextHolder;
//import com.qhkj.scm.common.annotation.DataSource;
//import com.qhkj.scm.common.enums.DataSourceType;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
///**
// * @ClassName DataSourceHandle
// * @Description TODO
// * @Author zouwenhai
// * @Date 2020/12/10 22:24
// * @Version 1.0
// */
//@Component
//@Aspect
//public class DataSourceHandle {
//
//    //定义切面，指被@DataSource注解的方法被拦截
//    @Pointcut("@annotation(com.qhkj.scm.common.annotation.DataSource)")
//    public void pointcut() {
//    }
//
//
//    //该方法在进入被@DataSource注解的方法前执行，切换数据源
//    @Before("pointcut()")
//    public void changeDataSource(JoinPoint point) {
//        Class clazz = point.getTarget().getClass();
//        String methodName = point.getSignature().getName();
//        Class[] classes = ((MethodSignature) point.getSignature()).getParameterTypes();
//
//        try {
//            Method method = clazz.getMethod(methodName, classes);
//            if (method.isAnnotationPresent(DataSource.class)) {
//                DataSource dataSource = method.getAnnotation(DataSource.class);
//                DataSourceType dataSourceType = dataSource.value();
//                DataSourceContextHolder.setDatasource(dataSourceType.name());
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //该方法在进入被@DataSource注解的方法前执行，清除当前数据源
//    @After("pointcut()")
//    public void clearDatasource() {
//        DataSourceContextHolder.clearDatasource();
//    }
//}
