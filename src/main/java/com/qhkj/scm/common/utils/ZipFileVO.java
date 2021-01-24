package com.qhkj.scm.common.utils;

import lombok.Data;

import java.io.InputStream;

/**
 * @ClassName ZipFileVO
 * @Description TODO
 * @Author zouwenhai
 * @Date 2021/1/24 22:38
 * @Version 1.0
 */
@Data
public class ZipFileVO {


    private String fileName;

    private InputStream inputStream;
}
