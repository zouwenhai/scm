package com.qhkj.scm.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zouwenhai
 * @date 2021/3/31 10:10
 */
@Data
public class UserVO {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    private LocalDateTime updateTime;
}
