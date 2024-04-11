package com.chenyue.experiment.thread.entity;

/**
 * @author chenyue7@foxmail.com
 */
public class User {
    private int id;
    private String name;
    public User(){
        this.id = 0;
        this.name = "0";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
