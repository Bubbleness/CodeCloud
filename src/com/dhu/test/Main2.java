package com.dhu.test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[m];
            for (int j = 0; j < n; j++)
                nums1[j] = sc.nextInt();
            for (int j = 0; j < n; j++)
                nums2[j] = sc.nextInt();
            System.out.println("yes");
        }
    }

        public static BigInteger getMulNumber ( int[] nums){
            if (nums.length == 0)
                return new BigInteger("0");

            BigInteger ans = new BigInteger("1");
            for (int i = 0; i < nums.length; i++) {
                BigInteger temp = new BigInteger(String.valueOf(nums[i]));
                ans = ans.multiply(temp);
            }
            return ans;
        }


    }
