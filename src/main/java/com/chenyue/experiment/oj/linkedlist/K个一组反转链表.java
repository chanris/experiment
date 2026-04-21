package com.chenyue.experiment.oj.linkedlist;


/**
 * @author chenyue7@qq.com
 * @date 2026/4/8
 */
public class K个一组反转链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        ListNode node5 = reverseKGroup(node, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy  = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true) {
            ListNode kth = getKth(groupPrev, k);
            // -1(groupPrev), 1(cur), 2, 3(groupNext, prev)
            if(kth == null) break;
            ListNode groupNext = kth.next;

            // 反转当前组
            ListNode prev = groupNext, cur = groupPrev.next;
            while(cur != groupNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            // prev== 2, groupPrev.next = prev;
            //

            // 连接前后段
            ListNode tmp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private static ListNode getKth(ListNode cur, int k) {
        while(cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
