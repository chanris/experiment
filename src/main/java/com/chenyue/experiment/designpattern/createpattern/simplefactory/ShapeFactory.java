package com.chenyue.experiment.designpattern.createpattern.simplefactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class ShapeFactory {
    // 使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
