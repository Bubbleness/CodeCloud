package com.dhu.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,5,6,6};
        int n = removeDuplicate(arr);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(n);
    }

    public static int removeDuplicate(int[] nums){

//        int i;
//        int j = 1;
//        for(i=1;i<n;i++){
//            if(nums[i] != nums[j-1])
//                nums[j++] = nums[i];
//        }
//        return i;
        int n = nums.length;
        if(n == 0 || n == 1)
            return n;
        int count = 1;
        for(int i=0;i<n-1;i++){
            if (nums[i]  != nums[i+1])
                nums[count++] = nums[i+1];
        }
        return count;
    }
}