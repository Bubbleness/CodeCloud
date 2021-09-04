package com.dhu.niuke;

public class NC128 {

    public long maxWater (int[] arr) {

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = arr.length-1;
        int sum = 0;
        while(left < right){
            leftMax = Math.max(arr[left],leftMax);
            rightMax = Math.max(arr[right],rightMax);

            if(arr[left] < arr[right]){
                sum += (leftMax - arr[left]);
                left++;
            }else{
                sum += (rightMax-arr[right]);
                right--;
            }
        }
        return sum;
    }


    // 动态规划的解法
    public long maxWater_dp (int[] height) {

        if (height.length == 0)
            return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];

        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        for(int j=height.length-2;j>=0;j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }

        long ans = 0;
        for(int i=0;i< height.length;i++){
            ans += (Math.min(leftMax[i],rightMax[i])- height[i]);
        }
        return ans;
    }
}
