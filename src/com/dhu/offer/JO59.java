package com.dhu.offer;

import java.util.*;

public class JO59 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if(n <= 0 || k == 0 || k > n)
            return new int[]{};
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for(int i=0;i<k;i++){
            maxHeap.offer(new int[]{nums[i],i});
        }

        int[] res = new int[n-k+1];
        res[0] = maxHeap.peek()[0];
        for(int i=k;i<nums.length;i++){
            maxHeap.offer(new int[]{nums[i],i});
            while (maxHeap.peek()[1] <= i-k){
                maxHeap.poll();
            }
            res[i-k+1] = maxHeap.peek()[0];
        }
        return res;
    }


    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k){

        int n = nums.length;
        if(n <= 0 || k == 0 || k > n)
            return new int[]{};

        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        int[] ans = new int[n-k+1];
        ans[0] = nums[dq.peekFirst()];
        for(int i=k;i<n;i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i);
            while(dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            ans[i-k+1] = nums[dq.peekFirst()];
        }
        return ans;
    }
}
