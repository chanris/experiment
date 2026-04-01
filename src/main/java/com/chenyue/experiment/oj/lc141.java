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
        boolean b = hasCycle2(listNode);
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


    public static boolean hasCycle2(lc206.ListNode head) {
        lc206.ListNode slow = head, fast = head;
        while(slow != fast) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            }else {
                return false;
            }
            if(slow == null || fast == null) return false;
        }
        return true;
    }
}
