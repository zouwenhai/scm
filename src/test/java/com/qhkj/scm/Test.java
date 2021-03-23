package com.qhkj.scm;

import com.qhkj.scm.common.config.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zouwenhai
 * @date 2021/1/28 10:31
 */
public class Test {


    /**
     * 堆溢出
     */
    public void test1() {
        for (; ; ) {
            List list = new ArrayList(2000);
        }

    }


    /**
     * 栈溢出
     *
     * @return void
     * @author zouwenhai
     * @date 2021/1/28 10:38
     */
    public void testStack() {
        this.testStack();
    }

    public static void main(String[] args) {
        Test test = new Test();
//        test.test1();
        test.testStack();
    }





}
