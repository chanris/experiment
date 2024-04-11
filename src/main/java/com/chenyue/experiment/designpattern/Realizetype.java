package com.chenyue.experiment.designpattern;

/**
 * @author chenyue7@foxmail.com
 *
 *
 * Object clone 是浅拷贝,直接二进制流的拷贝,比new的性能更好
 */
public class Realizetype implements Cloneable{

    private ModuleA moduleA;

    public ModuleA getModuleA() {
        return moduleA;
    }

    public void setModuleA(ModuleA moduleA) {
        this.moduleA = moduleA;
    }

    Realizetype() {
        System.out.println("具体原型创建成功!");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype)super.clone();
    }


}

class ModuleA {

}

class PrototypeTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        obj1.setModuleA(new ModuleA());
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1.moduleA==obj2.moduleA?"+(obj1.getModuleA()==obj2.getModuleA()));
    }
}

























