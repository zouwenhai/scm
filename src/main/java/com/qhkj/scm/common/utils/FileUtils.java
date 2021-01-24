package com.qhkj.scm.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author zouwenhai
 * @Date 2021/1/24 16:53
 * @Version 1.0
 */
@Slf4j
public class FileUtils {

    public static final String downUrl = "http://cash.test.youyuwo.com/87b062cin/upload/kyc/2019-12-11/OCR_AADHAAR_BACK_265123580491.jpg";
    public static final String downUrl2 = "http://cash.test.youyuwo.com/87b062cin/upload/kyc/2019-12-11/OCR_AADHAAR_BACK_265123580491.jpg";


    /**
     * 从原程下载文件
     *
     * @throws IOException
     */

    public static void downLoadFile() throws IOException {

        URL url = new URL(downUrl);
        InputStream inputStream = url.openStream();
        //TODO 怎么保持文件原来的名字
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\image\\a.jpg");
        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, len);
        }
        inputStream.close();
        fileOutputStream.close();

    }

    public static List<ZipFileVO> downLoadFile2() throws IOException {

        List<String> list = Arrays.asList(downUrl, downUrl2);
        List<ZipFileVO> zipFileVOS = new ArrayList<>();
        for (String str : list) {
            URL url = new URL(str);
            InputStream inputStream = url.openStream();
            ZipFileVO zipFileVO = new ZipFileVO();
            zipFileVO.setInputStream(inputStream);
            zipFileVO.setFileName(String.valueOf(UUID.randomUUID().toString().concat(".jpg")));
            zipFileVOS.add(zipFileVO);
        }
        return zipFileVOS;
    }


    /**
     * 压缩文件
     */
    public static void compress(List<ZipFileVO> list, String fileName, HttpServletResponse response) {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("GB2312"), "ISO-8859-1"));
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            zos = new ZipOutputStream(out);
            byte[] bufs = new byte[1024 * 10];
            for (ZipFileVO zipFileVO : list) {
                String streamfilename = zipFileVO.getFileName();
                // 创建ZIP实体，并添加进压缩包
                ZipEntry zipEntry = new ZipEntry(streamfilename);
                zos.putNextEntry(zipEntry);
                // 读取待压缩的文件并写进压缩包里
                bis = new BufferedInputStream(zipFileVO.getInputStream(), 1024 * 10);
                int read = 0;
                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                    zos.write(bufs, 0, read);
                }
            }
            zos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                bis.close();
                zos.close();
                out.close();
                for (ZipFileVO zipFileVO : list) {
                    try {
                        zipFileVO.getInputStream().read();
                    } catch (Exception e) {
                        log.error("{}输入流已经关闭", zipFileVO.getFileName());
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }


    }


    public static void main(String[] args) {
        try {
            downLoadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
