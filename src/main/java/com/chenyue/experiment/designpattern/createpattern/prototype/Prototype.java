package com.chenyue.experiment.designpattern.createpattern.prototype;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Prototype implements Cloneable{
    private String id;
    private String type;
    private String data;

    public Prototype(String id, String type, String data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(String data) {
        this.data = data;
    }

    /**
     * 知识点：Object内部的本地方法实现clone() 是浅拷贝。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Prototype clone() throws CloneNotSupportedException { // 重写可以提升封装作用域范围
        Prototype clone = (Prototype) super.clone(); // 浅拷贝
        /**
         * 如果对象成员变量中有引用类型，需要手动实现深拷贝，即创建引用对象的副本。
         */
        return clone;
    }
}
