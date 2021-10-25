package com.dhu.niuke;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class NC48 {

    public int search (int[] nums, int target) {
        // write code here
        if(nums.length == 0)
            return -1;

        int left = 0 , right = nums.length-1;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid]){

            }

        }
        return 0;
    }

    public int search2 (int[] nums, int target) {
        // write code here
        if(nums.length == 0)
            return -1;

        int index = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                index = i;
                break;
            }
        }

        System.out.println("index = " + index);
        if(index == -1)
            return binarySearch(nums,0,nums.length-1,target);
        else{
            int left = 0 , right = nums.length-1;
            int ans1 = binarySearch(nums,left,index,target);
            int ans2 = binarySearch(nums,index+1,right,target);
            if(ans1 == -1 && ans2 == -1) return -1;
            if(ans1 == -1) return ans2;
            else return ans1;
        }
    }

    public static int binarySearch(int[] nums,int left , int right , int target){

        if(left > right)
            return -1;
        int low = left , high = right;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
