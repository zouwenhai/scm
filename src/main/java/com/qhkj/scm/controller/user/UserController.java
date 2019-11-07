package com.qhkj.scm.controller.user;

import com.qhkj.scm.model.dto.UserReqDTO;
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
public class UserController {


    @PostMapping("/login")
    public String login(@Valid @RequestBody UserReqDTO userReqDTO) {
        return userReqDTO.toString();
    }


}



