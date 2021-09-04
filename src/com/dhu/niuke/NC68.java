package com.dhu.niuke;

public class NC68 {

    /**
    * @Description:  青蛙跳台阶
    * @Param:
    * @return:
    * @Author: Yushui
    * @Date: 2021/8/13 9:25
    */
    public int jumpFloor(int target) {

        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int n = target;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[target];
    }
}
