package com.qhkj.scm.model.dto;

import com.qhkj.scm.common.enums.SexTypeEnum;
import com.qhkj.scm.model.Sex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName AddUserReq
 * @Description TODO
 * @Author zouwenhai
 * @Date 2021/1/20 22:53
 * @Version 1.0
 */
@Data
@ApiModel(value = "添加用户")
public class AddUserReq {


    @ApiModelProperty(value = "姓名", required = true, example = "zhagnsan")
    private String name;

    @ApiModelProperty(value = "性别", required = true, example = "")
    private SexTypeEnum sexTypeEnum;
}
