package com.chenyue.experiment.jvm.javassist;

import javassist.*;

/**
 * @author chenyue7@foxmail.com
 */
public class CreatePerson {

    public static void createPerson() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 创建一个空类
        CtClass cc = pool.makeClass("com.chenyue.klass.javassist.Person");
        // 添加一个字段
        CtField param = new CtField(pool.get("java.lang.String"), "name", cc);
        //设置访问权限
        param.setModifiers(Modifier.PRIVATE);

        cc.addField(param, CtField.Initializer.constant("xiaoming"));
        //生产getter, setter 方法
        cc.addMethod(CtNewMethod.setter("setName", param));
        cc.addMethod(CtNewMethod.getter("getName", param));

        //添加无参构造
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"xiaohong\";}");
        cc.addConstructor(cons);

        //添加有参构造
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, cc);
        // $0=this /$1, $2, $3 代表方法参数
        cons.setBody("{$0.name = $1;}");
        cc.addConstructor(cons);

        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        cc.addMethod(ctMethod);

        cc.writeFile("F:/IDEA workspace/experiment/target/");
    }

    public static void main(String[] args) throws Exception {
        createPerson();
    }
}
