package com.chenyue.experiment.oj;


/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/24
 */
public class lc92 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseBetween(listNode,2,4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null, post = null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy, next = null;
        int k = 0;
        while(cur != null) {
            if(k == left) {
                break;
            }
            pre = cur;
            cur = cur.next;
            k++;
        }
        while(cur != null) {
            if(k == right + 1) {
                break;
            }
            next = cur.next;
            cur.next = post;
            post = cur;
            cur = next;
            k++;
        }
        pre.next.next = next;
        pre.next = post;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
