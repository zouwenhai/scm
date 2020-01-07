package com.qhkj.scm.service;

import com.qhkj.scm.mapper.SeatMapper;
import com.qhkj.scm.model.SeatOrderPO;
import com.qhkj.scm.model.SeatPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Autowired
    private SeatOrderService seatOrderService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(SeatPO seatPO) {
        seatMapper.updateByPrimaryKeySelective(seatPO);
        SeatOrderPO seatOrderPO = new SeatOrderPO();
        seatOrderPO.setNumber(seatPO.getNumber());
        seatOrderPO.setStudyEndTime(new Date());
        seatOrderPO.setStudyEndTime(new Date());
        seatOrderPO.setUserId("1");
        seatOrderService.save(seatOrderPO);
        return seatOrderService.save(seatOrderPO);
    }
}
