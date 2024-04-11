package com.chenyue.experiment.oj.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 31/3/2024
 * @description
 */
public class lc25 {
    public static void main(String[] args) {

    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while(cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int len = list.size();
        ListNode prev = pre;
        for (int i = 0; i < len / k; i++) {
            int left = i * k;
            int right = (i + 1) * k; // [left, right)
            ListNode post = list.get(right - 1).next;
            for (int j = right - 1; j > left; j--) {
                list.get(j).next = list.get(j - 1);
            }
            list.get(left).next = post;
            prev.next = list.get(right - 1);
            prev = list.get(left);
        }

        return  pre.next;
    }
}
