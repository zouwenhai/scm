package com.qhkj.scm.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/11/8 13:44
 * @work //AES加密切面类
 */

@Aspect
@Component
@Slf4j
public class AesEncodeAspect {


    @Before(value = "@annotation(com.qhkj.scm.common.annotation.AesEncode)")
    public void aesEncode(JoinPoint joinPoint) {
        log.info("进入切面类");
    }


}
