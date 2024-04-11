package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/19
 *
 * 单一职责原则
 * 接口隔离原则
 * 依赖倒转原则
 * 里氏替换原则
 * 开闭原则 ocp
 * 迪米特法则
 * 合成复用原则
 *
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleClone simpleClone = new SimpleClone("simpleClone",new Tag(1, "java"));
        SimpleClone simpleClone1 = (SimpleClone) simpleClone.clone();
        System.out.println(simpleClone.getTag() == simpleClone1.getTag());
    }
}

class SimpleClone implements Cloneable{
    private String className;
    private Tag tag;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public SimpleClone(String className, Tag tag) {
        this.className = className;
        this.tag = tag;
    }

    // 浅拷贝: 所有引用类型都是引用相同的对象，并没有创建新的对象
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone(); /*Object 默认的clone是本地方法实现的是浅拷贝*/
        if (clone instanceof SimpleClone){
            ((SimpleClone) clone).tag =new Tag(-1,"default-by-clone");
        }
        return  clone;
    }
}

class Tag  {
    private Integer tagId;
    private String tagName;

    public Tag(Integer tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

