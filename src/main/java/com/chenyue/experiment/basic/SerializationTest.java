package com.chenyue.experiment.basic;

import java.io.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/17
 * @description 测试序列化
 * 序列化的作用将java对象转为二进制数据，
 * 反序列化将二进制数据转为java对象
 * 序列UID的作用：
 * 1. 版本控制，serialVersionUID 用于验证序列化对象和反序列化对象是否兼容。
 * 2. 如果没有显式定义serialVersionUID，Java编译器会根据类的特征生产一个serialVersionUID，在这种情况下，序列化前后的版本号可能会不同，
 * 导致反序列化失败。
 *
 * 为什么只要显式声明了类的serialVersionUID，即使类的结构发生了改变，也不会影响类的反序列化？
 * 因为，只要反序列化时，从二进制数据中拿到的serialVersionID和类的serialVersionUID，从语义上说明，这个变化是可兼容的，
 * 那么Java会把二进制数据中存在的而类中不存在的字段的数据忽略掉（不会爆反序列化错误），而类中新加的字段，二进制数据中没有的字段赋默认值。
 */
public class SerializationTest {

    public static void main(String[] args) throws IOException {
//        serialization();
        deserialization();
    }

    public static void serialization() throws IOException {
        PlainBean bean = new PlainBean();
        bean.setAge(24);
        bean.setGender("直男");
        bean.setName("陈跃");
        File file = new File("person.ser");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
            oos.writeObject(bean);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialization() throws IOException {
        PlainBean bean = new PlainBean();
        FileInputStream fos = new FileInputStream("person.ser");
        ObjectInputStream ois = new ObjectInputStream(fos);
        try {
            PlainBean o =(PlainBean) ois.readObject();
            System.out.println(o);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class PlainBean implements Serializable {
        @Serial
        private static final  long serialVersionUID = 1L;
        private String name;
        private Integer age;
        private String gender;
        private String address;

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

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "PlainBean{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
