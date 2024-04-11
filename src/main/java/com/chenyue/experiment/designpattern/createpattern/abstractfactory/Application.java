package com.chenyue.experiment.designpattern.createpattern.abstractfactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
