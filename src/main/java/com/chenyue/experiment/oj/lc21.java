package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 27/3/2024
 * @description
 */
public class lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1, p2, cur1, cur2;
        if(list1 == null && list2 == null) {
            return null;
        }else if(list1 == null && list2 != null){
            return list2;
        }else if(list1 != null && list2 == null){
            return list1;
        }

        if(list1.val >= list2.val) {
            p1 = list1;
            p2 = list2;
        }else {
            p1 = list2;
            p2 = list1;
        }

        while(p1 != null) {
            if(p1.val >= p2.val && (p2.next != null && p2.next.val >= p1.val)) {
                cur1 = p1;
                cur2 = p2;
                p1 = p1.next;
                p2 = p2.next;
                cur2.next = cur1;
                cur1.next = p2;
                p2 = cur1;
            }else if(p1.val >= p2.val && (p2.next != null && p2.next.val < p1.val)) {
                p2 = p2.next;
            }else if(p1.val >= p2.val && p2.next == null) {
                cur1 = p1;
                p1 = p1.next;
                p2.next = cur1;
                cur1.next = null;
            }
        }

        return list1.val >= list2.val ? list2 : list1;
    }

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
