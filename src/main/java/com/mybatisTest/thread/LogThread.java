package com.mybatisTest.thread;

import com.mybatisTest.utils.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class LogThread implements Runnable{

    private Resource resource;

    public LogThread(Resource resource) {
        this.resource = resource;
    }



    @Override
    public void run() {
        while(true){
            try {
                resource.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
