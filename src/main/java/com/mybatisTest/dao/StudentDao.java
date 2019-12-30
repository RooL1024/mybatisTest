package com.mybatisTest.dao;

import com.mybatisTest.domain.Student;


public interface StudentDao {

    public Student findById(Integer id);

    public int countAll();

    public int insertStudent(Student student);

    public int deleteById(Integer id);

    public int updateStudent(Student student);


}
