package com.qhkj.scm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/7 17:12
 * @work //TODO
 */
@ApiModel("座位订单表")
@Getter
@Setter
@Table(name = "TB_SEAT_ORDER")
public class SeatOrderPO implements Serializable {


    private static final long serialVersionUID = 5517054164765587675L;

    @ApiModelProperty("id")
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    @ApiModelProperty("座位编号")
    private String number;


    @ApiModelProperty("用户id")
    @Column(name = "userId")
    private String userId;

    @ApiModelProperty("学习开始时间")
    @Column(name = "STUDY_START_TIME")
    private Date studyStartTime;

    @ApiModelProperty("学习结束时间")
    @Column(name = "STUDY_END_TIME")
    private Date studyEndTime;


}
