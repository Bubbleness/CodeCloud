package com.dhu.niuke;

public class NC21 {

    public ListNode reverseBetween (ListNode head, int m, int n) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        // 找翻转开始节点的前一个节点
        for(int i=1;i<=m-1;i++)
            pre = pre.next;

        ListNode rightNode = pre;

        // 找翻转结束节点
        for(int i=1;i<=n-m+1;i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        // 翻转结束节点的后一个节点
        ListNode post = rightNode.next;
        // 断开
        pre.next = null;
        rightNode.next = null;
        reverseList(leftNode,rightNode);
        pre.next = rightNode;
        leftNode.next = post;
        return dummyNode.next;
    }

    public void reverseList(ListNode start , ListNode end){

        if(start == end)
            return;

        ListNode pre,p,r;

        pre = start;
        start = start.next;
        pre.next = null;

        while(start != end){

            r = start.next;

            start.next = pre;
            pre = start;
            start = r;
        }

        start.next = pre;
    }
}
