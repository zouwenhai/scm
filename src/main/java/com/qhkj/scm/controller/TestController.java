package com.qhkj.scm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zouwenhai
 * @date 2021/4/21 17:25
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {


    @GetMapping(value = "/test1")
    public void test1() {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(new byte[5 * 1024 * 1024]);
            System.out.println("分配次数：" + (++i));
        }

    }
}
