package com.qhkj.scm;


import java.io.File;
import java.util.ArrayList;

import java.util.List;


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
/*        Test test = new Test();
//        test.test1();
        test.testStack();


        LinkedList list = new LinkedList();
        list.get(1);*/
        System.out.println("adfsfas".substring(1));
        System.out.println(File.separator);

    }

    /**
     * 就是通过
     *
     * @return void
     * @author zouwenhai
     * @date 2021/3/25 10:09
     */
    @org.junit.Test
    public void test4() {
        System.out.println("4");
        String a = "name";
        CallBack1 callBack1 = new CallBack1(a) {
            @Override
            protected byte[] inRedis(byte[] rawKey) {
                System.out.println(rawKey);
                return null;
            }
        };

        callBack1.doInRedis(3);
    }


    @org.junit.Test
    public void test5() {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new byte[5 * 1024 * 1024]);
            System.out.println("分配次数：" + (++i));
        }

    }


}
