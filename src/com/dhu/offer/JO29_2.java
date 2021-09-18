package com.dhu.offer;

public class JO29_2 {

    // 91 / 106
    public ListNode insert1(ListNode head, int insertVal) {

        if (head == null){
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }

        if(head.next == head){
            ListNode r = new ListNode(insertVal);
            if(insertVal >= head.val){
                head.next = r;
                r.next = head;
                return head;
            }else{
                r.next = head;
                head.next = r;
                return head;
            }
        }

        ListNode p = head;

        while(true){

            if(p.val > insertVal) {
                if(p.next != head && p.val <= p.next.val)
                    p = p.next;
                else{
                    ListNode o = new ListNode(insertVal);
                    o.next = p.next;
                    p.next = o;
                    return head;
                }
            }else if(p.val == insertVal){
                ListNode temp = new ListNode(insertVal);
                temp.next = p.next;
                p.next = temp;
                return head;
            }else{
                if(p.next.val < insertVal){
                    if(p.next != head && p.val >= p.next.val)
                        p = p.next;
                    else{
                        ListNode k = new ListNode(insertVal);
                        k.next = p.next;
                        p.next = k;
                        return head;
                    }
                }else{
                    ListNode s = new ListNode(insertVal);
                    s.next = p.next;
                    p.next = s;
                    return head;
                }
            }
        }
    }


    public ListNode insert(ListNode head, int insertVal){

        ListNode node = new ListNode(insertVal);
        if(head == null){
            node.next = node;
            return node;
        }

        ListNode cur = head , maxNode = null;
        boolean flag = false;
        int maxVal = Integer.MIN_VALUE;
        int isTrue = 1;

        while(cur != head || isTrue == 1){
            isTrue = 2;
            int temp = cur.val - cur.next.val;
            if(temp > maxVal){
                maxVal = temp;
                maxNode = cur;
            }

            if(insertVal >= cur.val && insertVal <= cur.next.val){
                node.next = cur.next;
                cur.next = node;
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if(!flag){
            ListNode minNode = maxNode.next;
            maxNode.next = node;
            node.next = minNode;
        }
        return head;
    }
}
