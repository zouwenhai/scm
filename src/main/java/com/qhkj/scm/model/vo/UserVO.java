package com.qhkj.scm.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName UserVO
 * @Description
 * @Author zouwenhai
 * @Date 2021/3/30 22:15
 * @Version 1.0
 */
@Data
public class UserVO {


    private Long id;

    private Date createTime;


    /**
     * localDateTime取的是系统的时区
     */
    private LocalDateTime updateTime;

    /**
     * Date默认是0时区
     * JsonFormat 注解默认时区是0
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime1;
}
