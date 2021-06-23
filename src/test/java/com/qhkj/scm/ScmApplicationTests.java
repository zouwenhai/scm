package com.qhkj.scm;

import com.qhkj.scm.mapper.SeatMapper;
import com.qhkj.scm.mapper.UserMapper;
import com.qhkj.scm.model.Man;
import com.qhkj.scm.model.SeatPO;
import com.qhkj.scm.model.entity.UserEntity;
import com.qhkj.scm.model.vo.UserVO;
import com.qhkj.scm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScmApplication.class)//指定启动类
@Slf4j
public class ScmApplicationTests {


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {


    }


    @Test
    public void userTest() {

        List<UserEntity> userEntities = userMapper.selectAll();
        log.info(userEntities.get(0).toString());
        redisTemplate.opsForValue().set("name", "张三");
        System.out.println(redisTemplate.opsForValue().get("name"));

    }

    @Test
    public void userInsert() {

        userService.batchInsert();
    }


    @Test
    public void update() {
        UserEntity userEntity = userMapper.selectByPrimaryKey(9);
        userEntity.setRealName("李四");
        //在进行更新之前，它会通过注解获取当前对象的version值，然后加1，所以在更新时，version一定要有值
        //否则会报错
        userMapper.updateByPrimaryKeySelective(userEntity);
    }

    @Test
    public void test() {
        UserEntity userEntity = new UserEntity();
        userEntity.setRealName("李四");
        userEntity.setUserName("李四");
        userEntity.setPassword("zou19941205");
        userMapper.insert(userEntity);

    }


    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            SeatPO seatPO = new SeatPO();
            seatPO.setNumber(String.valueOf(i));
            seatMapper.insertSelective(seatPO);
        }
    }


    /**
     * 先执行子线程
     * 子线程执行完毕后再再执行主线程
     *
     * @throws InterruptedException
     */
    @Test
    public void test3() throws InterruptedException {
        System.out.println(String.format("开始"));
        CountDownLatch countDownLatch = new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserName("a");
                    userEntity.setRealName("A");
                    userService.add(userEntity);
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(String.format("主线程开始执行：", Thread.currentThread().getName()));

    }


    @Test
    public void test4() {
        userService.udUser();

    }


    @Test
    public void test5() {
        //验证下如果补货异常是否还会触发事务回滚
        userService.deleteAllData();
        // userService.deleteData();
    }

    @Test
    public void test6() {
        userService.batchInsert();
    }


    @Test
    public void test7() {

        UserEntity userEntity = new UserEntity();
        userEntity.setAge(1);
        userMapper.insertSelective(userEntity);
    }


    @Test
    public void test8() {
        UserVO userVO = userMapper.getList();
        System.out.println(userVO.getCreateTime());
        System.out.println(userVO.getUpdateTime());
    }

    @Test
    public void test9() {

        List<UserEntity> list = userMapper.selectAll();

        UserEntity userEntity = new UserEntity();
        userEntity.setMobile("123231");

    }


}

