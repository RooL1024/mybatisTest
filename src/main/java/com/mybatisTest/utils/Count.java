package com.mybatisTest.utils;

public class Count {
    private volatile int count = 0;
    public void add(){
        count++;
    }
    public int getCount(){
        return count;
    }

}
