package com.chenyue.experiment.oj.linkedlist;

/**
 * @author chenyue7@foxmail.com
 * @date 22/4/2024
 * @description 反转链， 要求一趟遍历完成
 */
public class 反转链表 {
    public static void main(String[] args) {
        /*Node dummy = new Node();
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        int m = 2;
        int n = 4;
        dummy.next = head;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node cur = head;
        Node pre = null;
        for(int i = 1; i <  m &&cur != null; i++,pre = cur, cur = cur.next) {

        }
        pre.next = null;
        for(int i = 0; cur != null && i <= (n - m); i++) {
            Node next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        node2.next = node5;
        for (cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + "-->");
        }*/
        Node dummy = new Node();
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        dummy.next = head;
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node cur = head; // 当前节点指向头结点
        dummy.next = null; // dummy指向null，意思是‘第零轮’的节点
        for(; cur != null;) {
            Node next = cur.next; // 保存当前节点的next节点
            cur.next = dummy.next; // 指向上一轮的cur节点
            dummy.next = cur; // 保存当前轮的cur节点，方便下一轮使用
            cur = next; // 更新cur节点，向右移动
        }
        for (cur = dummy.next; cur != null; cur = cur.next) {
            System.out.print(cur.val + "-->");
        }System.out.print("NULL");
    }

    public static class Node {
        public Node next;
        public int val;
        public Node(){}
        public Node(int val){this.val = val;}
    }
}
