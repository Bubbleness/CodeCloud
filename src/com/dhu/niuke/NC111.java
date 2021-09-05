package com.dhu.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NC111 {

    public String solve (int[] nums) {

        if(nums.length == 0)
            return "0";

        int n = nums.length;
        ArrayList<String> strs = new ArrayList<>(n);
        for(int num : nums){
            strs.add(String.valueOf(num));
        }

        // 想要逆序 就把后面的放在前面
        // 比如：将 o2+o1 放在 o1+o2 前面
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(strs.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }

        return sb.toString();
    }
}
