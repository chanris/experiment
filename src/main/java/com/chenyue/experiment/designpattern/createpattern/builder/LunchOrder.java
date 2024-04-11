package com.chenyue.experiment.designpattern.createpattern.builder;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * 定义需要构建的对象
 */
public class LunchOrder {
    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    private LunchOrder(Builder builder) {
        this.bread = builder.bread;
        this.condiments = builder.condiments;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    // getters
    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    // 构建者作为静态内部类
    public static class Builder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public Builder() {
        }

        // 每个构建方法返回 构建者，形成链式调用
        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }

        // 重点：当构建完成后，手动调用build方法返回构建对象实例，完成构建。
        public LunchOrder build() {
            return new LunchOrder(this);
        }
    }
}
