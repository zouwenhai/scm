package com.qhkj.scm.controller;

import com.qhkj.scm.common.annotation.AesEncode;
import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.UserPO;
import com.qhkj.scm.model.dto.UserReqDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/20 11:32
 * @work //TODO
 */
@RestController
@RequestMapping("/user")
@Api(value = "测试Controller", tags = "测试类")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @ApiOperation(value = "测试方法")
    @PostMapping("/login")
    @AesEncode
    public String login(@Valid @RequestBody UserReqDTO userReqDTO) {
        UserPO userEntity = new UserPO();
        userEntity.setRealName("李四");
        userEntity.setUserName("李四");
        userEntity.setPassword("zou19941205");
        userMapper.insert(userEntity);
        return userReqDTO.toString();
    }


}



