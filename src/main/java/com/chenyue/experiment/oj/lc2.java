package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 */
public class lc2 {
    public static void main(String[] args) {
        lc2 lc2 = new lc2();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0; // 进位标志
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode ans = new ListNode();
        ListNode cur = ans;
        ListNode prev = cur;
        while (node1 != null && node2 != null) {
            cur.val = ((node1.val + node2.val + c) % 10);
            c = ((node1.val + node2.val + c) / 10);
            cur.next = new ListNode();
            prev = cur;
            cur = cur.next;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 == null && node2 == null) {
            if (c != 0) {
                cur.val = c;
            } else {
                prev.next = null;
            }
        } else if (node1 != null && node2 == null) {
            while (node1 != null) {
                cur.val = ((node1.val + c) % 10);
                c = ((node1.val + c) / 10);
                cur.next = new ListNode();
                prev = cur;
                cur = cur.next;
                node1 = node1.next;
            }
            if (c != 0) {
                cur.val = c;
            } else {
                prev.next = null;
            }
        } else if (node1 == null && node2 != null) {
            while (node2 != null) {
                cur.val = ((node2.val + c) % 10);
                c = ((node2.val + c) / 10);
                cur.next = new ListNode();
                prev = cur;
                cur = cur.next;
                node2 = node2.next;
            }
            if (c != 0) {
                cur.val = c;
            } else {
                prev.next = null;
            }
        }
        return ans;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
