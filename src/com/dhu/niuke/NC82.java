package com.dhu.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NC82 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        if(num.length == 0 || size == 0 || size > num.length)
            return new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for(int i=0;i<size;i++){
            maxHeap.offer(new int[]{num[i],i});
        }

        ArrayList<Integer> res = new ArrayList<>(num.length-size+1);
        res.add(maxHeap.peek()[0]);
        for(int i=size;i<num.length;i++){
            maxHeap.offer(new int[]{num[i],i});
            while (maxHeap.peek()[1] <= i-size){
                maxHeap.poll();
            }
            res.add(maxHeap.peek()[0]);
        }
        return res;
    }
}
