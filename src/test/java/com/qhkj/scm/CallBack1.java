package com.qhkj.scm;


/**
 * @author zouwenhai
 * @date 2021/3/25 9:39
 */
public abstract class CallBack1 implements CallBackTest {
    private String key;

    public CallBack1(String key) {
        this.key = key;
    }


    public final byte[] doInRedis(int a) {
        byte[] result = inRedis(key.getBytes());
        return result;
    }

    protected abstract byte[] inRedis(byte[] rawKey);

}
