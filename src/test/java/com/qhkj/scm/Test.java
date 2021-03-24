package com.qhkj.scm;



import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
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
        System.out.println(File.separator);

    }






}
