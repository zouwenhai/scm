package com.qhkj.scm.service;

import com.qhkj.scm.mapper.SeatMapper;
import com.qhkj.scm.model.SeatPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/7 17:23
 * @work //TODO
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatMapper seatMapper;


    @Override
    public int save(SeatPO seatPO) {
        return seatMapper.insertSelective(seatPO);
    }
}
