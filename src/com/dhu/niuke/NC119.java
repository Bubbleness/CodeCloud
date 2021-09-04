package com.dhu.niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class NC119 {
    
    /** 
    * @Description:  NC119 最小的K个数
    * @Param:  
    * @return:  
    * @Author: Yushui
    * @Date: 2021/8/15 15:11
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

//        for(int num : nums)
//            System.out.print(num + " ");
//        System.out.println();
//        heapSort(nums,n);
//        for(int num : nums)
//            System.out.print(num + " ");

        ArrayList<Integer> list = GetLeastNumbers_Solution(nums,k);
        for(Integer num : list)
            System.out.print(num+" ");
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(input.length < k)
            return new ArrayList<>();

        if (input.length == 0 || k == 0)
            return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        int len = input.length;
        createHeap(input);
        while(k > 0){
            result.add(input[0]);
            int temp = input[0];
            input[0] = input[len-1];
            input[len-1] = temp;
            adjustHeap(input,len-1,0);
            len--;
            k--;
        }
        return result;
    }



    public static void createHeap(int[] nums){
        for(int i=nums.length/2;i>=0;i--){
            adjustHeap(nums,nums.length,i);
        }
    }

    public static void adjustHeap(int[] nums,int len,int i){
        int k = i;
        int temp = nums[k];
        int index = 2*k+1;
        while(index < len){
            if(index+1 < len && nums[index] > nums[index+1]){
                index += 1;
            }

            if(nums[index] < temp){
                nums[k] = nums[index];
                k = index;
                index = 2*k+1;
            }else
                break;
        }
        nums[k] = temp;
    }

    public static void heapSort(int[] nums){
        int len = nums.length;
        createHeap(nums);
        for(int i=len-1;i>=1;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeap(nums,i,0);
        }
    }
}
