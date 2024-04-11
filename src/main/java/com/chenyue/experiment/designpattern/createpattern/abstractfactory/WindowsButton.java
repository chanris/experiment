package com.chenyue.experiment.designpattern.createpattern.abstractfactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Render a button in a Windows style.");
    }
}
