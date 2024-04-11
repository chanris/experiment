package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2022/1/20 22:26
 */
public class NC2 {
    static int length = 0;

    public static void main(String[] args) {

    }
    public static void solve(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode second = head.next;
        ListNode tail = second.next;
        ListNode pre = second;
        while (tail.next != null) {
            pre = tail;
            tail = tail.next;
        }

        pre.next = null;
        head.next = tail;
        tail.next = second;
        head = second;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


