package com.qhkj.scm;

import com.qhkj.scm.common.config.ThreadPool;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author zouwenhai
 * @date 2021/3/23 18:12
 */
public class ThreadPoolExecuterTest {


    /**
     * @return void
     * @author zouwenhai
     * @date 2021/3/23 18:12
     */
    @org.junit.Test
    public void test3() {
        ThreadPoolExecutor fixedThread = ThreadPool.newFixedThreadPoolByReject(3, 10, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
        for (int i = 0; i < 13; i++) {
            Task task = new Task();
            task.setNum(i);
            fixedThread.submit(task);
        }

    }


    /**
     * CallerRunsPolicy队列拒绝策略（当任务超过最大线程数时，阻塞队列会让调用线程（主线程）去执行任务，降低任务提交速度）
     *
     * @return void
     * @author zouwenhai
     * @date 2021/3/23 18:40
     */
    @Test
    public void test4() {

        ThreadPoolExecutor fixedThread = ThreadPool.newFixedThreadPoolByRejectCallRunsPolicy(3, 10, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 15; i++) {
            Task task = new Task();
            task.setNum(i);
            fixedThread.submit(task);
        }

    }

    public class Task implements Runnable {
        private Integer num;

        @Override
        public void run() {
            try {
                System.out.println(String.format(num.toString().concat(":%s"), Thread.currentThread().getName()));
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }
}
