package com.qhkj.scm.common.annotation;

import java.lang.annotation.*;

/**
 * @author zouwenhai
 * @date 2021/5/31 11:45
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Documented
public @interface AesEncodeMethod {

}
