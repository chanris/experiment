package com.chenyue.experiment.os;

import com.chenyue.experiment.os.model.PcbInfo;

/**
 * @author chenyue7@foxmail.com
 *
 * 循环列表
 */
public class Node {
    public Node first;
    public Node next;
    public PcbInfo data;
    public int size = 0; // 列表长度

    public Node() {
    }

    public Integer getPriority(){
        return 0;
    }

    public Node(PcbInfo data) {
        this.data = data;
    }

    public static NodeBuilder builder(){
        return new NodeBuilder();
    }

    /**
     * 从firstNode开始遍历count个节点
     * @param count 节点数
     */
    public void traverse(int count){
        if (this.first == null){
            System.out.println("改节点没有记录firstNode");
            return;
        }
        Node curNode = this.first;
        for(int i = 0; i < count; i++){
            System.out.println(curNode.data);
            curNode = curNode.next;
        }
    }

    /**
     * 插入到末尾
     */
    public void append(Node newNode){
        if (newNode == null){
            System.out.println("新节点不可为空");
            return;
        }
        Node curNode = this.first;
        while(curNode.next !=  first){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        newNode.first = this.first;
        newNode.next = this.first;
    }


    /**
     *
     * build() return FirstNode
     * append(new CycLinkedList)
     */
    public static class NodeBuilder {
        private Node fistNode;
        private Node curNode;

        public NodeBuilder append(Node node){
            if (fistNode == null && node != null){
                fistNode = node;
                curNode = fistNode;
                fistNode.first = fistNode;
                fistNode.size = 1;
            }
            if (fistNode != null && node != null){
                curNode.next = node;
                curNode.first = fistNode;
                curNode = curNode.next;
                fistNode.size += 1;
            }else {
                throw new RuntimeException("链表节点不可为空");
            }
            return this;
        }


        public NodeBuilder append(PcbInfo pcbInfo){
            Node node = new Node(pcbInfo);
            if (fistNode == null){
                fistNode = node;
                curNode = fistNode;
                fistNode.first = fistNode;
                fistNode.size = 1;
            }else {
                curNode.next = node;
                curNode.first = fistNode;
                curNode = curNode.next;
                fistNode.size += 1;
            }
            return this;
        }

        public Node build(){
            curNode.next = fistNode;
            return fistNode;
        }

    }

}
