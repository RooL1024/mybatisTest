package com.mybatisTest.thread;

import com.mybatisTest.dao.StudentDao;
import com.mybatisTest.domain.Student;
import com.mybatisTest.utils.Count;
import com.mybatisTest.utils.MysqlUtils;
import com.mybatisTest.utils.Resource;
import org.apache.ibatis.session.SqlSession;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueryThread implements Runnable{
    private Count count;
    private Resource resource;
    double excTime;
    Lock lock = new ReentrantLock();


    public QueryThread(Count count, Resource resource) {
        this.count = count;
        this.resource = resource;
    }



    @Override
    public void run() {
        SqlSession session = MysqlUtils.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        while(true) {
            long startTime = System.nanoTime();//记录开始时间
            Student stu = studentDao.findByName("小张");
            System.out.println(stu);
            long endTime = System.nanoTime();//记录结束时间
            excTime = (double) (endTime - startTime)/1000000;//计算插入操作耗费时间
            session.commit();
            lock.lock();
            try {
                count.add();
            }finally {
                lock.unlock();
            }
            try {
                resource.create(String.format("%.2f",excTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
