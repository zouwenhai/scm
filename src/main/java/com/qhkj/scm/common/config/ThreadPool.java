package com.qhkj.scm.common.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义四种不同拒绝策略的线程池
 *
 * @author zouwenhai
 * @date 2021/3/23 16:25
 */
public class ThreadPool {


    /**
     * 生成一个固定大小的线程池，默认拒绝策略（AbortPolicy：当运行的线程数大于最大线程数时，再往阻塞队列里面添加任务时就会拒绝并抛出异常）
     *
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime   存活时间
     * @param unit            时间单位
     * @param workQueue       工作队列
     * @return java.util.concurrent.ThreadPoolExecutor
     * @author zouwenhai
     * @date 2021/3/23 16:38
     */
    public static ThreadPoolExecutor newFixedThreadPoolByReject(int corePoolSize,
                                                                int maximumPoolSize,
                                                                long keepAliveTime,
                                                                TimeUnit unit,
                                                                BlockingQueue<Runnable> workQueue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    /**
     * 生成一个固定大小的线程池，默认拒绝策略（AbortPolicy：当运行的线程数大于最大线程数时，再往阻塞队列里面添加任务时就会拒绝但是不抛出异常）
     *
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数
     * @param keepAliveTime   存活时间
     * @param unit            时间单位
     * @param workQueue       工作队列
     * @return java.util.concurrent.ThreadPoolExecutor
     * @author zouwenhai
     * @date 2021/3/23 18:20
     */
    public static ThreadPoolExecutor newFixedThreadPoolByRejectNotThrow(int corePoolSize,
                                                                        int maximumPoolSize,
                                                                        long keepAliveTime,
                                                                        TimeUnit unit,
                                                                        BlockingQueue<Runnable> workQueue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadPoolExecutor.DiscardPolicy());
    }


    /**
     * 生成一个固定大小的线程池，默认拒绝策略（AbortPolicy：当运行的线程数大于最大线程数时，再往阻塞队列里面添加任务时就会丢弃最先进来的任务，然后将新任务再添加进来）
     *
     * @param corePoolSize
     * @param maximumPoolSize
     * @param keepAliveTime
     * @param unit
     * @param workQueue
     * @return java.util.concurrent.ThreadPoolExecutor
     * @author zouwenhai
     * @date 2021/3/23 18:26
     */
    public static ThreadPoolExecutor newFixedThreadPoolByRejectDisCardOldPolicy(int corePoolSize,
                                                                                int maximumPoolSize,
                                                                                long keepAliveTime,
                                                                                TimeUnit unit,
                                                                                BlockingQueue<Runnable> workQueue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadPoolExecutor.DiscardOldestPolicy());

    }




    public static ThreadPoolExecutor newFixedThreadPoolByRejectCallRunsPolicy(int corePoolSize,
                                                                              int maximumPoolSize,
                                                                              long keepAliveTime,
                                                                              TimeUnit unit,
                                                                              BlockingQueue<Runnable> workQueue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());

    }

}
