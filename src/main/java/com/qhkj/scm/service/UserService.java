package com.qhkj.scm.service;

import com.qhkj.scm.model.entity.UserEntity;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/9/13 15:44
 * @Version 1.0
 */
public interface UserService {


    void batchInsert();

    void add(UserEntity userEntity);

    /**
     * 更新和删除
     */
    void udUser();

    void deleteData(int id);

    void deleteAllData();
}
