package com.zhangxp.tree;

/**
 * @author ：zhangxp
 * @description: 二叉树的结点定义
 * @date ：2021/8/6 13:12
 */
public class TreeNode {
    public int val;
    /**
     * 左子树
     */
    public TreeNode leftNode;
    /**
     * 右子树
     */
    public TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }

    public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
