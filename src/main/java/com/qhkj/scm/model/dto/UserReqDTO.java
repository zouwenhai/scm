package com.qhkj.scm.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.Version;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/25 14:26
 * @work //TODO
 */
@ApiModel("用户请求DTO")
@Getter
@Setter
public class UserReqDTO implements Serializable {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String passWord;

    @NotNull(message = "年龄不能为空")
    private Integer age;


    @Override
    public String toString() {
        return "UserReqDTO{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}
