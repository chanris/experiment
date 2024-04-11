package com.chenyue.experiment.designpattern;

/**
 * @author chenyue7@foxmail.com
 */
public class Client {

    public interface Product{
        void show();
    }

    static class ConcreteProduct implements Product{
        public void show(){
            System.out.println("产品1");
        }
    }

    static class ConcreteProduct2 implements Product{
        public void show(){
            System.out.println("产品2");
        }
    }

    final class Constant {
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
        static final int PRODUCT_C = 2;

    }

    static class SimpleFactory{
        public static Product makeProduct(int kind){
            switch (kind){
                case Constant.PRODUCT_A:
                    return new ConcreteProduct();
                case Constant.PRODUCT_B:
                    return new ConcreteProduct2();
            }
            return null;
        }

    }

}
