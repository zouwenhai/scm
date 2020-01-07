package com.qhkj.scm.service;

import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.UserPO;
import com.qhkj.scm.model.WoMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/9/13 15:45
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void batchInsert() {
        int count = 5;

        for (int i = 0; i < count; i++) {
            UserPO userEntity = new UserPO();
            userEntity.setUserName("聪聪");
            userEntity.setSex(new WoMan());
            userEntity.setPassword("123");
            userEntity.setRealName("王五");
            userEntity.setGender("M");
            userEntity.setAge(20);
            userEntity.setVersion(0);
            userEntity.setIdCard(UUID.randomUUID().toString());
            userMapper.insertSelective(userEntity);
        }



    }
}
