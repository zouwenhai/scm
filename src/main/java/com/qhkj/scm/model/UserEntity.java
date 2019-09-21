package com.qhkj.scm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

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


    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "select SEQ_TB_USER.nextVal from dual")
    @Id
    private Long id;



    @Column(name = "USER_NAME")
    private String userName;


    @Column(name = "PASSWORD")
    private String password;


    @Column(name = "REAL_NAME")
    private String realName;


    @Column(name = "SEX")
    private Sex sex;

    @Column(name="ID_CARD")
    private String idCard;



}
