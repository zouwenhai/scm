package com.qhkj.scm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataSourceType {

    /**
     * 主库
     */
    MASTER,
    /**
     * 从库
     */
    SLAVER

}
