package com.dhu.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class NC14 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if (pRoot == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(pRoot,1));
        int tempDepth = 1;
        while(!queue.isEmpty()){

            Node temp = queue.poll();
            if(temp.depth == tempDepth){
                cur.add(temp.node.val);
            }else{

                result.add(new ArrayList<>(cur));
                cur.clear();
                tempDepth++;
                cur.add(temp.node.val);
            }

            if(temp.node.left != null)
                queue.add(new Node(temp.node.left,temp.depth+1));
            if(temp.node.right != null)
                queue.add(new Node(temp.node.right,temp.depth+1));

        }

        result.add(new ArrayList<>(cur));

        for(int i=1;i<result.size();i+=2){
            Collections.reverse(result.get(i));
        }
        return result;
    }
}

class Node{
    TreeNode node;
    int depth;

    public Node(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
