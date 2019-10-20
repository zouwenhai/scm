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


    @Test
    public void update() {
        UserEntity userEntity = userMapper.selectByPrimaryKey(9);
        userEntity.setRealName("张三");
        //在进行更新之前，它会通过注解获取当前对象的version值，然后加1，所以在更新时，version一定要有值
        //否则会报错
        userMapper.updateByPrimaryKeySelective(userEntity);
    }

    @Test
    public void test(){
        UserEntity userEntity  = new UserEntity();
        userEntity.setRealName("李四");
        userMapper.insert(userEntity);

    }


}
