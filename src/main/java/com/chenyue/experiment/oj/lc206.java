package com.chenyue.experiment.oj;

import java.util.ArrayList;

/**
 * @author chenyue7@foxmail.com
 * @date 5/3/2024
 * @description
 */
public class lc206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode node = reverseList(listNode);
        System.out.println(node.val);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ArrayList<ListNode> lst = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            lst.add(tmp);
            tmp = tmp.next;
        }
        for (int i = lst.size() - 1; i > 0; i--) {
            lst.get(i).next = lst.get(i - 1);
        }
        if (lst.size() < 2) {
            return lst.get(0);
        }
        lst.get(0).next = null;
        return lst.get(lst.size() - 1);
    }

     static class ListNode {
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
