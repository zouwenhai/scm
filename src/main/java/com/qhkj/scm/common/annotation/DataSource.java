package com.qhkj.scm.common.annotation;

import com.qhkj.scm.common.enums.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
public @interface DataSource {

    DataSourceType value() default DataSourceType.MASTER;


}
