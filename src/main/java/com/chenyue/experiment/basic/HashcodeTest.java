package com.chenyue.experiment.basic;


import java.util.HashSet;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试哈希冲突，实验结果表明重复大量创建同种类就会发生哈希冲突
 */
public class HashcodeTest {
    public static void main(String[] args) {
        class Fruit {
            int count;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 110000; i++) {
            int hashcode = new Fruit().hashCode();
            if (!set.contains(hashcode)) {
                set.add(hashcode);
            }else {
                System.out.println("发生Hash冲突，在第"+i+"次");
                break;
            }
        }
    }
}
