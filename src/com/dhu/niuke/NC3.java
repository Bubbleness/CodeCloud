package com.dhu.niuke;

import java.util.HashSet;
import java.util.Set;

public class NC3 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if(pHead == null)
            return null;
        Set<ListNode> set = new HashSet<>();

        while(pHead != null){

            if(set.contains(pHead)){
                return pHead;
            }

            set.add(pHead);
            pHead = pHead.next;
        }

        return null;
    }
}
