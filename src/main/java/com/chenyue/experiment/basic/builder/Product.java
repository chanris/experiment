package com.chenyue.experiment.basic.builder;

/**
 * @author chenyue7@foxmail.com
 */
public class Product {

    private Integer id;
    private String name;
    private Integer type;
    private Float price;

    private Product(Integer id, String name, Integer type, Float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder{  //public 全包可见
        private Integer id;
        private String name;
        private Integer type;
        private Float price;


        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder price(Float price) {
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(this.id, this.name, this.type, this.price);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
    public static void main(String[] args) {
        Product p = Product.builder().id(1).name("chenyue").type(1).price(1.0f).build();
        System.out.println(p);
    }
}
