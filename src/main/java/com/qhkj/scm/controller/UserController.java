package com.qhkj.scm.controller;

import com.qhkj.scm.common.annotation.AesEncode;
import com.qhkj.scm.common.enums.SexTypeEnum;
import com.qhkj.scm.common.utils.FileUtils;
import com.qhkj.scm.common.utils.ZipFileVO;
import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.SeatPO;
import com.qhkj.scm.model.dto.AddUserReq;
import com.qhkj.scm.model.entity.UserEntity;
import com.qhkj.scm.model.dto.UserReq;
import com.qhkj.scm.model.req.UserReq2;
import com.qhkj.scm.model.vo.UserVO;
import com.qhkj.scm.service.SeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zouwenhai
 * @version v1.0
 * @date 2019/10/20 11:32
 * @work //TODO
 */
@RestController
@RequestMapping("/user")
@Api(value = "测试Controller", tags = "测试类")
@Slf4j
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private SeatService seatService;

    private static Lock lock = new ReentrantLock();


    @ApiOperation(value = "测试方法")
    @PostMapping("/login")
    @AesEncode
    public String login(@Valid @RequestBody UserReq userReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setRealName("李四");
        userEntity.setUserName("李四");
        userEntity.setPassword("zou19941205");
        userMapper.insert(userEntity);
        return userReq.toString();
    }


    @ApiOperation(value = "入座")
    @PostMapping("/seat")
    public String seat(Long id) {
        SeatPO seatPO = new SeatPO();
        seatPO.setId(id);
        seatPO.setIdIdle(1);
        seatService.update(seatPO);
        return "success";
    }


    @ApiOperation(value = "添加用户")
    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute AddUserReq addUserReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setSexTypeEnum(addUserReq.getSexTypeEnum());
        userEntity.setUserName(addUserReq.getName());
        userMapper.insertSelective(userEntity);
        return "success";
    }


    @ApiOperation(value = "查询")
    @GetMapping(value = "/user/{userId}")
    @ApiImplicitParam(value = "用户id", name = "userId", example = "1", required = true)
    public String user(Long userId) {
        lock.lock();
        UserEntity userEntity = userMapper.findList(userId, SexTypeEnum.WOMAN);

        return "success";
    }


    @ApiOperation(value = "下载zip文件")
    @GetMapping(value = "/download")
    @SneakyThrows
    public void downLoanFile(HttpServletResponse response) {

        List<ZipFileVO> list = FileUtils.downLoadFile2();
        FileUtils.compress(list, "photo.zip", response);
    }


    @ApiOperation(value = "添加用户")
    @GetMapping(value = "/batch/add")
    public void add() {
        int i = 0;
        while (true) {
            log.info("i:{}", i++);
            UserEntity userEntity = new UserEntity();
            userEntity.setAge(i++);
        }

    }


    @SneakyThrows
    @ApiOperation(value = "获取ip地址")
    @GetMapping(value = "/ip/get")
    public String getIp() {
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
            if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                continue;
            } else {
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        log.info("ip地址：", ip);
                    }
                }
            }

        }
        return "success";
    }

    @ApiOperation(value = "测试方法2")
    @PostMapping("/test2")
    public UserVO test2(@RequestBody UserReq2 userReq) {
        UserVO userVO = userMapper.getList();
        return userVO;
    }
}



