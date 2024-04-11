package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 */
public class lc24 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;
        lc24 lc24 = new lc24();
        ListNode head = lc24.swapPairs(node);
        System.out.println(head.val);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        for (; cur != null; cur = cur.next) {
            list.add(cur);
        }
        int len = list.size();
        ListNode node1;
        ListNode node2;
        ListNode prev;
        ListNode post;

        ListNode first = head;
        ListNode end = list.get(len - 1);
        ListNode tmp;
        for (int i = 0; i < len; i += 2) {
            if (i == 0) {
                head = list.get(i + 1);
                tmp = list.get(i + 1).next;
                list.get(i + 1).next = first;
                first.next = tmp;

                tmp = list.get(i);
                list.set(i , list.get(i + 1));
                list.set(i + 1, tmp);
            } else if (i == len - 2) {
                list.get(i - 1).next = end;
                end.next = list.get(i);
                list.get(i).next = null;
            } else if (i > 0 && i < len - 2) {
                node1 = list.get(i);
                node2 = node1.next;
                prev = list.get(i - 1);
                post = node2.next;

                prev.next = node2;
                node2.next = node1;
                node1.next = post;

                tmp = list.get(i);
                list.set(i , list.get(i + 1));
                list.set(i + 1, tmp);
            }
        }
        return head;
    }

    public static class ListNode {
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
