package com.dhu.niuke;

public class NC72 {

    public TreeNode Mirror (TreeNode pRoot) {

        if(pRoot == null)
            return pRoot;
        return exchangeSubTree(pRoot);
    }

    public static TreeNode exchangeSubTree(TreeNode root){
        if(root == null)
            return root;

        TreeNode leftSubTree = exchangeSubTree(root.left);
        TreeNode rightSubTree = exchangeSubTree(root.right);
        root.left = rightSubTree;
        root.right = leftSubTree;
        return root;
    }
}
