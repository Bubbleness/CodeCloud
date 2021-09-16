package com.dhu.offer;

public class JO28 {

    // 判断二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return judge(root.left , root.right);
    }

    public static boolean judge(TreeNode leftTree , TreeNode rightTree){

        if(leftTree == null && rightTree == null)
            return true;
        if(leftTree == null || rightTree == null || leftTree.val != rightTree.val)
            return false;
        return judge(leftTree.left,rightTree.right) && judge(leftTree.right , rightTree.left);
    }


}
