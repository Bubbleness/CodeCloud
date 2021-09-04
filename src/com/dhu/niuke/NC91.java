package com.dhu.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NC91 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        NC91 nc = new NC91();
        int[] res = nc.LIS(arr);
        for(int num : res)
            System.out.print(num + " ");
    }

    public int binarySearch(int num,ArrayList<Integer> dp){

        int low = 0,high = dp.size();
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(dp.get(mid) >= num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public int[] LIS (int[] arr) {
        // write code here

        ArrayList<Integer> len = new ArrayList<>();
        ArrayList<Integer> dp = new ArrayList<>();
        if(arr.length == 0)
            return null;
        if(arr.length == 1){
            dp.add(arr[0]);
            return dp.stream().mapToInt(Integer::valueOf).toArray();
        }

        len.add(1);
        dp.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i] > dp.get(dp.size()-1)){
                dp.add(arr[i]);
                len.add(dp.size());
            }else{
                int index = binarySearch(arr[i],dp);
                dp.set(index,arr[i]);
                len.add(index+1);
            }
        }


        ArrayList<Integer> res = new ArrayList<>();
        int maxLen = dp.size();
        for(int i=len.size()-1;i>=0;i--){
            if(len.get(i) == maxLen){
                res.add(arr[i]);
                maxLen--;
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
