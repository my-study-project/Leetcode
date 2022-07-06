package com.js;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Semaphore;

public class Solution {
    public static void main(String[] args) {
        int N = 8; //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

}

class Worker extends Thread {
    private int num;
    private Semaphore semaphore;

    public Worker(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("工人" + this.num + "占用一个机器在生产...");
            Thread.sleep(2000);
            System.out.println("工人" + this.num + "释放出机器");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Node copyRandomList1(Node head) {
        // 判空
        if (Objects.isNull(head)) {
            return null;
        }
        //1、复制指针的next
        copyNext(head);
        //2、复制指针的 random
        copyRandom(head);

        return split(head);

    }

    private static void copyRandom(Node head) {
        Node tempNode = head;

        while (tempNode != null) {
            Node random = new Node(tempNode.random.val);
            tempNode.next.random = random;
            tempNode = tempNode.next.next;
        }
    }

    private static void copyNext(Node head) {
        Node tempNode = head;

        while (tempNode != null) {
            Node newNode = new Node(tempNode.val);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            tempNode = tempNode.next.next;
        }
    }

    private static Node split(Node head) {
        Node result = head.next;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
        }
        // 拆分两个node
        return result;
    }

    /**
     * @return
     * @Description: 深度拷贝带随机指针的链表
     * @Param [head]
     * @Date: 2021/10/3 4:05 下午
     */
    public static Node copyRandomList(Node head) {
        // 判空
        if (Objects.isNull(head)) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newNode = head;
        while (newNode != null) {
            if (!map.containsKey(newNode)) {
                Node copyNode = new Node(newNode.val);
                map.put(newNode, copyNode);
            }
            if (newNode.random != null) {
                Node random = newNode.random;
                if (!map.containsKey(random)) {
                    Node copyNode = new Node(random.val);
                    map.put(random, copyNode);
                }
                map.get(newNode).random = map.get(random);
            }
            newNode = newNode.next;
        }
        newNode = head;
        while (newNode != null) {
            Node next = newNode.next;
            map.get(newNode).next = map.get(next);
            newNode = newNode.next;
        }
        return map.get(head);
    }

//    public static void main(String[] args) {
//        Node node = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        node.random = node3;
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node2.random = node4;
//        node3.random = null;
//        System.out.println(node);
//        System.out.println(copyRandomList(node));
//
//        System.out.println(node == copyRandomList(node));
//    }

    /**
     * @return
     * @Description: 链表的插入排序
     * @Param [head]
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // pre指向有序的节点
        ListNode pre = head;
        // cur指向待排序的节点
        ListNode cur = head.next;
        //定义辅助节点
        ListNode aux = new ListNode(-1);
        aux.next = head;
        while (cur != null) {

            if (cur.val < pre.val) {
                pre.next = cur.next;
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                l1.next = cur;
                cur.next = l2;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }

    /**
     * @return
     * @Description: 矩形面积
     * @Param [ax1, ay1, ax2, ay2, bx1, by1, bx2, by2]
     * @Date: 2021/10/3 4:23 下午
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        return 0;
    }
}
