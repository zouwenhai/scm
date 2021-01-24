package com.qhkj.scm.mapper;

import com.qhkj.scm.common.enums.SexTypeEnum;
import com.qhkj.scm.model.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/8/31 23:55
 * @Version 1.0
 */
public interface UserMapper extends Mapper<UserEntity> {


    void updateUserByUserName(UserEntity userEntity);

    UserEntity findList(@Param("userId") Long userId, @Param("sex") SexTypeEnum woman);
}
