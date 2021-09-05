package com.dhu.niuke;

import org.omg.CORBA.NVList;

import java.util.Scanner;

public class NC74 {

    public int GetNumberOfK(int [] array , int k) {

        if(array.length == 0)
            return 0;
        int cnt = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == k){
                cnt++;
            }
            if(array[i] > k)
                break;
        }
        return cnt;
    }


    public int GetNumberOfK2(int [] array , int k) {

        if(array.length == 0)
            return 0;

        // 利用有序性 寻找上下界
        // 上界：不管目标值存在与否，都指向大于目标值的第一个值
        // 下界：如果存在目标值，则指向第一个目标值，否则，如果不存在， 则指向大于目标值的第一个值
        int lbound = 0;
        // 上界可以超出数组范围
        int rbound = array.length;
        int low = 0 , high = array.length;
        while (low < high){
            int mid = low + (high-low) / 2;
            if(k > array[mid]){
                low = mid + 1;
            }else{
                // 因为要找上界 找第一个比 k 大的元素
                // 所以第一个比 k 大的元素有可能是 array[mid]
                high = mid;
            }
        }

        lbound = low;

        low = 0;
        high = array.length;

        while(low < high){
            int mid = low + (high-low) / 2;
            if(k >= array[mid])
                low = mid + 1;
            else
                high = mid;
        }

        rbound = low;
        return rbound - lbound;

    }

    // 上界 ： 第一个比 target 大的元素下标
    public static int upper_bound(int[] nums,int low , int high ,int target){

        while(low < high){
            int mid = low + (high - low) / 2;
            if(target >= nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    // 下界 ： 第一个大于等于 target 的元素下标
    public static int lower_bound(int[] nums,int low , int high ,int target){

        while(low < high){
            int mid = low + (high - low) / 2;
            if(target > nums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();

        int tar = sc.nextInt();
        int upper = NC74.upper_bound(nums,0,nums.length,tar);
        int lower = NC74.lower_bound(nums,0,nums.length,tar);
        System.out.println("upper = "+upper);
        System.out.println("lower = "+lower);
    }

}
