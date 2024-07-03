package com.chenyue.experiment.jvm.loader;


/**
 * @author chenyue7@foxmail.com
 * @date 2020/08/23
 *
 * role: 测试类的加载时机
 */
public class A extends B{
    static {
        System.out.println("load class io.cyt.loader.A.");
//        if (true){
//            throw new IllegalStateException();
//        }
    }

    public static String str = "A class";

    public static void printClassName(){
        System.out.println(A.class); // qualified class name
    }


    @Override
    public void test() {
        System.out.println("Class A override Class B public method");
    }

    public static void load(){}



    public void testParams(String str) {
        str = "sd";
    }
    public static void main(String[] args) {
//        B b = new A();
//        b.test();

//        System.out.println(A.class.getName());

//        try {
//            A a1 = (A) a.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }


//        Query query = QueryFactory.createQuery();
//        Object obj = query.queryValue("select * from student where id = 3", null);
//        System.out.println(obj);
//        Properties properties = System.getProperties();
//        for (Object key : properties.keySet()){
//            System.out.println(key);
//        }

//        String path = A.class.getResource("/").getPath();
//        System.out.println(path);

//        QueryFactory.generatePoFiles();
    }
}
