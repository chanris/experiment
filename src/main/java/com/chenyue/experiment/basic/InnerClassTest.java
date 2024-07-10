package com.chenyue.experiment.basic;



/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 */
public class InnerClassTest {

    private String message = "Hello, Method Inner Class.";
    private static String staticMessage = "Hello, Static Inner Class.";

    // 成员内部类
    class MemberInnerClass {
        void display() {
            System.out.println(message);
        }
    }

    //静态内部类
    static class StaticInnerClass {
        void display() {
            System.out.println(staticMessage);
        }
    }

    //匿名内部类
    void myMethod() {
        AnonymousInnerClass inner = new AnonymousInnerClass() {
            @Override
            void display() {
                System.out.println("This is an anonymous inner class.");
            }
        };
        inner.display();
    }

    //局部内部类
    void anotherMethod() {
        class LocalInnerClass {
            void display() {
                System.out.println("Hello, Local Inner Class.");
            }
        }
        LocalInnerClass inner = new LocalInnerClass();
        inner.display();
    }


    public static void main(String[] args) {
//        InnerClassTest outer = new InnerClassTest();
//        InnerClassTest.MemberInnerClass inner = outer.new MemberInnerClass();
//        inner.display();

//        InnerClassTest.StaticInnerClass inner = new InnerClassTest.StaticInnerClass();
//        inner.display();

//        InnerClassTest outer = new InnerClassTest();
//        outer.myMethod();

        InnerClassTest outer = new InnerClassTest();
        outer.anotherMethod();
    }
}
abstract class AnonymousInnerClass {
    abstract void display();
}
