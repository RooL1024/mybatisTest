package com.mybatisTest.thread;


import com.mybatisTest.utils.Count;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CountThread implements Runnable{

    private Count count;
    int sec = 1;
    int temp = 0;

    public CountThread(Count count) throws IOException {
        this.count = count;
    }

    public void writeIntoFile(String s) throws IOException {
        File file = new File("file/QPS.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        //写入数据
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(s);
        bw.newLine();
        bw.close();
    }

    @Override
    public void run() {
        int n = count.getCount();
        String output = sec + "," + (n-temp);
        try {
            writeIntoFile(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sec++;
        temp = n;
    }

}
