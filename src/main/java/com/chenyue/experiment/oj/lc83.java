package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 17/1/2024
 * @description
 */
public class lc83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteDuplicates(head);
        traverse(head);

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            while(tmp != null) {
                if(tmp.val == cur.val) {
                    tmp = tmp.next;
                }else {
                    cur.next = tmp;
                    cur = tmp;
                    break;
                }
            }
            if(tmp == null) {
                cur.next = null;
                break;
            }
        }
        return head;
    }


    public static void traverse(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}

