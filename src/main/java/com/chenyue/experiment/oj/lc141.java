package com.chenyue.experiment.oj;

import java.util.HashMap;

/**
 * @author chenyue7@foxmail.com
 * @date 5/3/2024
 * @description ssx
 */
public class lc141 {

    public static void main(String[] args) {
        lc206.ListNode listNode = new lc206.ListNode(1);
        lc206.ListNode listNode2 = new lc206.ListNode(2);
        lc206.ListNode listNode3 = new lc206.ListNode(3);
        lc206.ListNode listNode4 = new lc206.ListNode(3);
        lc206.ListNode listNode5 = new lc206.ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode;
        boolean b = hasCycle(listNode);
        System.out.println(b);
    }

    public static boolean hasCycle(lc206.ListNode head) {
        lc206.ListNode quick, slow;
        quick = head;
        slow = head;
        while(slow != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            if(slow == quick) {
                return true;
            }else if(slow == null ||  quick == null) {
                return false;
            }
        }
        return false;
    }
}
