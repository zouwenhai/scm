package com.qhkj.scm.service;

import com.qhkj.scm.mapper.SeatMapper;
import com.qhkj.scm.mapper.SeatOrderMapper;
import com.qhkj.scm.model.SeatOrderPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2020/1/7 17:24
 * @work //TODO
 */
@Service
public class SeatOrderServiceImpl implements SeatOrderService {


    @Autowired
    SeatOrderMapper seatOrderMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int save(SeatOrderPO seatOrderPO) {
        return seatOrderMapper.insertSelective(seatOrderPO);
    }
}
