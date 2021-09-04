package com.dhu.niuke;

public class NC140 {

    public int[] MySort (int[] arr) {
        // write code here
        if(arr.length < 2)
            return arr;
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    public void quickSort(int[] nums,int left,int right){

        if(nums.length < 2)
            return;

        int low = left;
        int high = right;
        if(low >= high)
            return;
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] > temp){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp){
                low++;
            }
            nums[high] = nums[low];
        }

        nums[low] = temp;

        int index = low;
        quickSort(nums,left,index-1);
        quickSort(nums,index+1,right);
    }
}
