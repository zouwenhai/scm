package com.qhkj.scm.service;

import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.UserPO;
import com.qhkj.scm.model.WoMan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/9/13 15:45
 * @Version 1.0
 */
@Slf4j
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

    @Override
    public synchronized void add(UserPO userPO) {
        System.out.println(String.format("threadName:{%s}", Thread.currentThread().getName()));
        Example example = new Example(UserPO.class);
        example.createCriteria().andEqualTo("userName", userPO.getUserName());
        List<UserPO> list = userMapper.selectByExample(example);
        if (list.size() > 0) {
            log.info(String.format("该用户已经存在"));
            return;
        } else {
            userMapper.insertSelective(userPO);
        }
    }

    @Override
    public void udUser() {
        UserPO userPO = new UserPO();
        userPO.setId(14L);
        userPO = userMapper.selectByPrimaryKey(userPO);
        if (Objects.isNull(userPO)) {
            log.warn("对象为空");
            return;
        }
        userMapper.updateUserByUserName(userPO);
        userMapper.deleteByPrimaryKey(userPO);

    }

    @Override
    public void deleteData(int id) {

        if(id==5){
            userMapper.deleteByPrimaryKey(id);
        }
        else if(id==15){
            userMapper.deleteByPrimaryKey(id);
            String str = null;
            if (str.equals("")) {

            }

        }


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAllData() {

        for(int i=5;i<=15;i++){
            this.deleteData(i);
        }
        try {

        } catch (Exception e) {
            log.error("error", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
