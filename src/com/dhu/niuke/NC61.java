package com.dhu.niuke;

import java.util.ArrayList;
import java.util.List;

public class NC61 {

    public int[] twoSum (int[] numbers, int target) {
        // write code here

        int index1 = 0;
        int index2 = 0;

        List<Integer> nums = new ArrayList<>();
        for(int num : numbers)
            nums.add(num);


        for(int i=0;i<nums.size();i++){

            index1 = i+1;
            int temp = target - nums.get(i);
            if(nums.contains(temp)){
                index2 = nums.indexOf(temp) + 1;
                if(index2 < index1){
                    int t = index1;
                    index1 = index2;
                    index2 = t;
                    break;
                }

            }
        }

        int[] res = new int[2];
        res[0] = index1;
        res[1] = index2;
        return res;

    }
}
