package com.chenyue.experiment.datastructure.list;

import java.util.Arrays;
import java.util.Random;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/24
 * @description 手写跳表
 * 跳表：支持对数据的快速查找，插入和删除。
 * 跳表的期望值空间复杂度为O(n)，跳表的查询，插入和删除操作的期望时间复杂度都为O(logn)
 */
public class SkipListTest {

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(1);
        skipList.add(3);
        skipList.add(7);
        skipList.add(5);
//        boolean search = skipList.search(5); # true
        boolean search = skipList.search(6); // false
        System.out.println(search);
    }

    private static class SkipList {
        static final double P_FACTOR = 0.25;
        static int MAX_LEVEL = 32;
        // 记录跳表的 dummy节点
        private SkipListNode head;
        // 记录跳表的 最高层数，从0开始数
        private int level;
        private final Random random;

        public SkipList() {
            this.head = new SkipListNode(-1, MAX_LEVEL);
            this.level = 0;
            this.random = new Random();
        }

        public boolean search(int target) {
            SkipListNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while (curr.next[i] != null && curr.next[i].val < target) {
                    curr = curr.next[i];
                }
            }
            curr = curr.next[0];
            if(curr != null && curr.val == target) {
                return true;
            }
            return false;
        }

        /**
         * 跳表插入：
         * 从最大层level开始查找，在当前层水平逐个比较
         * 直到当前节点的下一个节点大于等于目标节点，然后移动至下一层，
         */
        public void add(int num) {
            // 需要更新的节点
            SkipListNode[] update = new SkipListNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkipListNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) { // level-1，从最高层开始数，数到第0层
                // 找到 第 i 层 小于且 最接近的 num 的元素
                while(curr.next[i] != null && curr.next[i].val < num) {
                    curr = curr.next[i];
                }
                update[i] = curr;
            }
            // 节点在P_FACTOR概率 下 可能上升的层数，最大上升MAX_LEVEL,
            int lv = randomLevel();
            level = Math.max(level, lv);
            SkipListNode newNode = new SkipListNode(num, lv);
            // 生成 num 跳表节点，该节点有 lv 层
            for (int i = 0; i < lv; i++) {
                newNode.next[i] = update[i].next[i];
                update[i].next[i] = newNode;
            }
        }

        public boolean erase(int num) {
            // 获得 比 num小的最大 SkipListNode
            SkipListNode[] update = new SkipListNode[MAX_LEVEL];
            SkipListNode curr = this.head;
            for (int i = level - 1; i >= 0; i--) {
                while(curr.next[i] != null && curr.next[i].val < num) {
                    curr = curr.next[i];
                }
                update[i] = curr;
            }
            curr = curr.next[0];
            if (curr == null || curr.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].next[i] != curr) {
                    break;
                }
                update[i].next[i] = curr.next[i];
            }
            while (level > 1 && head.next[level-1] == null) {
                level--;
            }
            return true;
        }

        /**
         * 返回一个新插入的节点可能会上升的层数
         */
        private  int randomLevel() {
            int lv = 1;
            while(random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }

        static class SkipListNode {
            int val;
            // 指向后面的节点
            SkipListNode[] next;
            public SkipListNode(int val, int maxLevel) {
                this.val = val;
                this.next = new SkipListNode[maxLevel];
            }
        }
    }


}
