package com.mybatisTest.test;

import com.mybatisTest.thread.CountThread;
import com.mybatisTest.thread.LogThread;
import com.mybatisTest.thread.QueryThread;
import com.mybatisTest.utils.Count;
import com.mybatisTest.utils.Resource;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestQuery {
    public static void main(String[] args) throws Exception {
        Count count = new Count();
        Resource resource = new Resource();

        //读取配置文件里的线程数
        Properties props = new Properties();
        InputStream in = TestInsert.class.getResourceAsStream("/config.properties");
        props.load(in);
        in.close();
        // 读取线程数设置
        int threads_num = Integer.parseInt(props.getProperty("Threads"));
//        配置线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(threads_num + 1);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        //创建线程类对象
        CountThread cou = new CountThread(count);
        LogThread log = new LogThread(resource);
        QueryThread que = new QueryThread(count, resource);
        //启动线程
        pool.submit(log);
        for(int i = 0;i < threads_num;i++){
            pool.submit(que);
        }
        //统计线程每秒统计
        service.scheduleAtFixedRate(cou, 3, 1, TimeUnit.SECONDS);

    }
}
