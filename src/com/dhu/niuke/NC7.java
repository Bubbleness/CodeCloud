package com.dhu.niuke;

public class NC7 {

    public int maxProfit (int[] prices) {

        int curMinPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int num : prices){

            maxProfit = Math.max(num-curMinPrice,maxProfit);
            curMinPrice = Math.min(curMinPrice,num);
        }
        return maxProfit;
    }
}
