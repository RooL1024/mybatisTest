package com.mybatisTest.thread;

import com.mybatisTest.dao.StudentDao;
import com.mybatisTest.domain.Student;
import com.mybatisTest.utils.Count;
import com.mybatisTest.utils.Resource;
import com.mybatisTest.utils.MysqlUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsertThread implements Runnable{

    private Count count;
    private Resource resource;
    double excTime;
    Lock lock = new ReentrantLock();


    public InsertThread(Count count, Resource resource) {
        this.count = count;
        this.resource = resource;
    }

    public static Student setStudent(){
        Student student = new Student();
        student.setStudent_number(1832134);
        student.setName("任乐1");
        student.setAge(24);
        student.setSex("男");
        student.setClassNum(4);
        student.setGrade("研二");
        student.setProfession("软件工程");
        student.setAcademy("软件学院");
        student.setTeacher_name("导师");
        student.setPhone_number("19852812863");
        student.setEmail("381269410@qq.com");
        student.setBirthday(new Date());
        student.setLocation("江苏省苏州市");
        return student;
    }

    @Override
    public void run() {
        Student student = InsertThread.setStudent();
        SqlSession session = MysqlUtils.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        while(true) {
            long startTime = System.nanoTime();//记录开始时间
            studentDao.insertStudent(student);//插入操作
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
