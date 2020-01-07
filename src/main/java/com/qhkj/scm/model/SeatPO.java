package com.qhkj.scm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/7 17:01
 * @work //TODO
 */
@ApiModel("座位信息表")
@Getter
@Setter
@Table(name = "TB_SEAT")
public class SeatPO implements Serializable {


    private static final long serialVersionUID = 8167495492773026705L;

    @ApiModelProperty("id")
    @Id
    @Column(name = "ID")
    private Long id;

    @ApiModelProperty("座位编号")
    @Column(name = "NUMBER")
    private String number;

    @ApiModelProperty("是否空闲")
    @Column(name = "IS_IDLE")
    private Integer idIdle;


}
