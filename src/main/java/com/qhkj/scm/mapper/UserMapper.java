package com.qhkj.scm.mapper;

import com.qhkj.scm.model.UserEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/8/31 23:55
 * @Version 1.0
 */
@Repository
public interface UserMapper extends Mapper<UserEntity> {



}
