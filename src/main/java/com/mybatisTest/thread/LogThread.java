package com.mybatisTest.thread;

import com.mybatisTest.utils.Resource;


public class LogThread implements Runnable{

    private Resource resource;
    int num = 1;

    public LogThread(Resource resource) {
        this.resource = resource;
    }



    @Override
    public void run() {
        while(true){
            try {
                resource.destroy();
                //查看插入条数
                System.out.println("已插入 " + (num++) + " 万条数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
