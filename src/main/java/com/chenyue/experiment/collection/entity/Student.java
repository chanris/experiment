package com.chenyue.experiment.collection.entity;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/1
 */
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String studentId;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String studentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
