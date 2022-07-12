package com.js.leetcode;

import com.js.ListNode;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟节点作为一个头挂着head
        ListNode dummy = new ListNode(0, head);
        // 获取链表的长度
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
