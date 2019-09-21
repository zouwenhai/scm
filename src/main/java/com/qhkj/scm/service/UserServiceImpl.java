package com.qhkj.scm.service;

import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.Man;
import com.qhkj.scm.model.UserEntity;
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
        int count =2000;

        for(int i=0;i<count;i++){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("郑爽");
            userEntity.setSex(new WoMan());
            userEntity.setPassword("123");
            userEntity.setRealName("郑爽");
            userEntity.setIdCard(UUID.randomUUID().toString());
            userMapper.insert(userEntity);

        }



    }
}
