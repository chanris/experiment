package com.chenyue.experiment.oj.linkedlist;

/**
 * @author chenyue7@foxmail.com
 * @date 17/4/2024
 * @description
 */
public class Test {

    public static void main(String[] args) {
        int m = 2;
        int n = 4;
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node pre = null;
        Node cur = node;
        for(int i = 0; i < m-1; i++) {
            pre = cur;
            cur = cur.next;
        }
        System.out.println(cur.val);
        System.out.println(pre.val);
        for(int i = 0; i < (n - m); i++) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = cur;
            pre.next = tmp;
            pre = tmp;
        }
        cur = node;
        for (;cur != null;cur = cur.next) {
            System.out.print(cur.val+"->");
        }
        System.out.print("NULL");
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
        public Node(){}
    }
}
