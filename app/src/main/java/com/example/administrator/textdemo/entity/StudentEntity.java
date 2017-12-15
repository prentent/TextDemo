package com.example.administrator.textdemo.entity;

/**
 * Created by Administrator on 2017/12/12.
 */

public class StudentEntity {
    private int age;
    private long idCard;
    private String sex;
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "age=" + age +
                ", idCard=" + idCard +
                ", sex='" + sex + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
