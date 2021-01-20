package com.qhkj.scm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName SexTypeEnum
 * @Description TODO
 * @Author zouwenhai
 * @Date 2021/1/20 23:07
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum SexTypeEnum {

    Man(0, "男性"),
    WOMAN(1, "女性");

    private final int code;

    private final String desc;
}
