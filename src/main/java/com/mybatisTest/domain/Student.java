package com.mybatisTest.domain;


import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Integer id;
    private Integer student_number;
    private String  name;
    private Integer age;
    private String sex;
    private int classNum;
    private String grade;
    private String profession;
    private String academy;
    private String teacher_name;
    private String phone_number;
    private String Email;
    private Date birthday;
    private String location;

    public Integer getId() {
        return id;
    }

    public Integer getStudent_number() {
        return student_number;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getClassNum() {
        return classNum;
    }

    public String getGrade() {
        return grade;
    }

    public String getProfession() {
        return profession;
    }

    public String getAcademy() {
        return academy;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return Email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudent_number(Integer student_number) {
        this.student_number = student_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_number=" + student_number +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", classNum=" + classNum +
                ", grade='" + grade + '\'' +
                ", profession='" + profession + '\'' +
                ", academy='" + academy + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", Email='" + Email + '\'' +
                ", birthday=" + birthday +
                ", location='" + location + '\'' +
                '}';
    }
}
