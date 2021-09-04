package com.dhu.niuke;

import java.util.HashMap;
import java.util.Map;

public class NC156 {

    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if((int)entry.getValue() == 1)
                return (int)entry.getKey();
        }
        return 0;
    }
}
