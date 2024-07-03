package com.chenyue.experiment.basic.inner;

/**
 * @author chenyue7@foxmail.com
 *
 * 内部类详解
 */
public class Outer {

    private String val = "外部类的字符串";

    //Outer.Inner inner = new Outer().new Inner();
    class Inner {
        private String inStr = "内部类的字符串";

        public void print(){
            //调用外部类的val属性
            System.out.println(val);
        }
    }

    //在外部类定义一个方法,g该方法负责生产内部类对象
    public void fun(){        //
        Inner in = new Inner();
        in.print();
    }

}
