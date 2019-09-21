package com.qhkj.scm;

import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.Sex;
import com.qhkj.scm.model.UserEntity;
import com.qhkj.scm.model.WoMan;
import com.qhkj.scm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScmApplication.class)//指定启动类
@Slf4j
public class ScmApplicationTests {


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {


    }


    @Test
    public void userTest() {

        List<UserEntity> userEntities = userMapper.selectAll();
        log.info(userEntities.get(0).toString());

    }

    @Test
    public void userInsert() {

        userService.batchInsert();
    }



}
