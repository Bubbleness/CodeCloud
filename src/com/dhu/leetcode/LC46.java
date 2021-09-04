package com.dhu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC46 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        LC46 lc = new LC46();
        List<List<Integer>> res = lc.permute(nums);

        for(int i=0;i<res.size();i++){
            for(int nu : res.get(i)){
                System.out.print(nu + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        if(nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] visited = new int[nums.length];
        DFS(nums,visited,temp,result);
        return result;

    }

    public void DFS(int[] nums, int[] visited, List<Integer> temp,List<List<Integer>> result){

        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                temp.add(nums[i]);
                DFS(nums,visited,temp,result);
                visited[i] = 0;
                temp.remove(temp.size()-1);
            }
        }
    }
}
