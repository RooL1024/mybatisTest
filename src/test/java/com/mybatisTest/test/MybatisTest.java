package com.mybatisTest.test;

import com.mybatisTest.dao.StudentDao;
import com.mybatisTest.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;


public class MybatisTest {

    private InputStream in ;
    private SqlSessionFactory factory;
    private SqlSession session;
    private StudentDao studentDao;


    @Test
    public void testSelect(){
        Student stu = studentDao.findById(199);
        System.out.println(stu);
    }


    @Test
    public void testcountAll(){
        int sum = studentDao.countAll();
        System.out.println("the total students is :" + sum);
    }

    @Test
    public void testInsert(){

        Student student = new Student();
        student.setStudent_number(1832133);
        student.setName("任乐");
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
        studentDao.insertStudent(student);
        int id = student.getId();
        System.out.println("the inserted student's id is: " + id);
    }

    @Test
    public void testDelete(){
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
        int res = studentDao.deleteById(10022);
        System.out.println("the delete student's id is: " + res);
    }


    @Test
    public void testUpdate(){
        Student student = studentDao.findById(1001);
        student.setName("小张");
        student.setAge(23);
        student.setSex("女");
        int res = studentDao.updateStudent(student);
        System.out.println(res);

    }


    @Before
    public void init()throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建 SqlSession 工厂对象
        factory = builder.build(in);
        //4.创建 SqlSession 对象
        session = factory.openSession();
        //5.创建 Dao 的代理对象
        studentDao = session.getMapper(StudentDao.class);
    }

    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception{
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }



}
