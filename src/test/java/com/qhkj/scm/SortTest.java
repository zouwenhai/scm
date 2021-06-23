package com.qhkj.scm;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 排序
 *
 * @author zouwenhai
 * @date 2021/5/24 16:04
 */
public class SortTest {


    @Test
    public void test1() {
        List<String> a = Arrays.asList("yyhudong2019", "yyhudong2019_fb", "yyhudong2019_gogle");
        a.forEach(System.out::println);
        a.stream().sorted(((o1, o2) -> o1.length() - o2.length() > 0 ? -1 : 1)).forEach(System.out::println);

    }
}
