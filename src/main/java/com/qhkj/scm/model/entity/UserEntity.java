package com.qhkj.scm.model.entity;

import com.qhkj.scm.common.annotation.AesEncode;
import com.qhkj.scm.common.enums.SexTypeEnum;
import com.qhkj.scm.handler.SexTypeHandler;
import com.qhkj.scm.handler.Sexhandler;
import com.qhkj.scm.model.Sex;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserEntity
 * @Description TODO
 * @Author zouwenhai
 * @Date 2019/8/31 23:21
 * @Version 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "TB_USER")
public class UserEntity implements Serializable {


    private static final long serialVersionUID = -6864719428965280679L;


    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REAL_NAME")
    private String realName;


    @Column(name = "ID_CARD")
    private String idCard;


    @Column(name = "AGE")
    private Integer age;

    @ApiModelProperty(name = "年级")
    @Column(name = "GENDER")
    private String gender;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    /**
     * 自定义的枚举转换器
     */
    @Column(name = "SEX")
    @ColumnType(typeHandler = SexTypeHandler.class)
    private SexTypeEnum sexTypeEnum;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    @AesEncode
    private String mobile;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;


    /*   *//**
     * 自定义类转换器
     *//*
    @Column(name = "SEX")
    @ColumnType(typeHandler = Sexhandler.class)
    private Sex sex;*/


}
