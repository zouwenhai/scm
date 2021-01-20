package com.qhkj.scm.handler;

import com.qhkj.scm.common.enums.SexTypeEnum;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

/**
 * @ClassName SexTypeHandler
 * @Description TODO
 * @Author zouwenhai
 * @Date 2021/1/20 23:09
 * @Version 1.0
 */
public class SexTypeHandler extends EnumOrdinalTypeHandler<SexTypeEnum> {

    public SexTypeHandler(Class<SexTypeEnum> type) {
        super(type);
    }
}
