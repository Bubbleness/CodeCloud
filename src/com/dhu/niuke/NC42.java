package com.dhu.niuke;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NC42 {


    public Set<String> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

        if(num.length == 0)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] vivited = new int[num.length];
        DFS(num,temp,result,vivited);
        return result;
    }

    public void DFS(int[] nums,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result,int[] visited){

        if(temp.size() == nums.length){

            if(!set.contains(temp.toString())){
                set.add(temp.toString());
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i] == 1)
                continue;
            visited[i] = 1;
            temp.add(nums[i]);
            DFS(nums,temp,result,visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
}
