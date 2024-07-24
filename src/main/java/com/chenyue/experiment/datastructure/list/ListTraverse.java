package com.chenyue.experiment.datastructure.list;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description 反转链表，要求空间常数阶
 */
public class ListTraverse {
    public static void main(String[] args) {
        Node head = createList(null, 1);
        createList(head, 2);
        createList(head, 3);
        createList(head, 4);
        createList(head, 5);

        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        Node p = head;
        Node cur = head;
        while (dummyHead.next != null) {
            cur = dummyHead.next;
            dummyHead.next = cur.next;
            cur.next = p;
            p = cur;
        }
        head.next = null;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static class Node {
        Node next;
        int val;
        public Node(int val) {this.val = val;}
    }

    private static Node createList(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        node.next = createList(node.next, val);
        return node;
    }
}
