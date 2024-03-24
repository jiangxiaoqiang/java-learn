package com.dolphin.gateway.algorithms;

public class BinaryTreeMirror {

    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

}
