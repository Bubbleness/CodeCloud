package com.dhu.leetcode;

public class LC572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        boolean isTrue = findRoot(root,subRoot);
        return isTrue;

    }

    /**
     * 树的思想： 先比较根，根不同就在左子树中进行寻找比较  然后在右子树中寻找比较
     * @param root
     * @param subRoot
     * @return
     */
    public boolean findRoot(TreeNode root , TreeNode subRoot){

        if(root == null)
            return false;

        return findRoot(root.left,subRoot) || isSameTree(root,subRoot) || findRoot(root.right,subRoot);

    }

    // 判断两个二叉树是否相等
    public boolean isSameTree(TreeNode root1 , TreeNode root2){

        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        boolean l = isSameTree(root1.left,root2.left);
        boolean r = isSameTree(root1.right,root2.right);
        return l && r;
    }
}
