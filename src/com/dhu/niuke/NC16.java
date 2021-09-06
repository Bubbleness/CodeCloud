package com.dhu.niuke;

import javax.naming.ldap.LdapReferralException;
import java.util.LinkedList;
import java.util.Queue;

public class NC16 {

    // 递归写法
    public boolean isSymmetric (TreeNode root) {
        // write code here
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return DFS(root.left,root.right);

    }

    public boolean DFS(TreeNode Lroot , TreeNode Rroot){

        // 左指针和右指针同时为空才为true
        if(Lroot == null && Rroot == null)
            return true;
        if(Lroot == null || Rroot == null)
            return false;
        if(Lroot.val != Rroot.val)
            return false;

        return DFS(Lroot.left,Rroot.right) && DFS(Lroot.right,Rroot.left);
    }

    // 非递归写法 ： 利用队列
    public boolean isSymmetric2 (TreeNode root) {
        // write code here
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if(leftNode == null && rightNode == null)
                continue;
            if(leftNode == null || rightNode == null || (leftNode.val != rightNode.val))
                return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
