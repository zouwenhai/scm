package com.qhkj.scm.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName UserReq2
 * @Description
 * @Author zouwenhai
 * @Date 2021/3/31 0:23
 * @Version 1.0
 */
@ApiModel(value = "用户请求参数")
@Data
public class UserReq2 {

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDay;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDay;
}
