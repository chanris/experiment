package com.chenyue.experiment.basic;

import java.util.HashSet;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试哈希冲突
 */
public class HashConflictTest {
    public static void main(String[] args) {
        class InnerClazz {
            int i;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 110000; i++) {
            int hashCode = new InnerClazz().hashCode();
            if (!set.contains(hashCode)) {
                set.add(hashCode);
            } else {
                System.out.println("发生hash冲突，在第" + i + "次！");
                break;
            }
        }
    }
}