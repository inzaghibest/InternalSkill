package com.zhangxp;

import com.zhangxp.tree.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 构造如下二叉树:
 *       2
 *   3        4
 *7    8    9
 * */
public class Main {
    public static TreeNode init() {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3, node1, node2);
        TreeNode node5 = new TreeNode(4, node3, null);
        return new TreeNode(2,node4, node5);
    }

    /**
     * 二叉树的前序遍历: 先遍历根节点，再遍历左子树和右子树
     * @param root: 二叉树的根节点
     */
    public static void preOrder(TreeNode root) {
        if (root!=null){
            System.out.print(root.val);
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    /**
     * 二叉树的中序遍历: 先遍历左子树，再输出父结点，最后遍历右子树
     * @param args: 二叉树的根节点
     */
    public static void inOrder(TreeNode root) {
        if (root.leftNode != null){
            inOrder(root.leftNode);
        }
        if (root != null) {
            System.out.print(root.val);
        }
        if (root.rightNode != null) {
            inOrder(root.rightNode);
        }
    }

    /**
     * 二叉树的后序遍历: 先遍历左子树，再遍历右子树，最后输出根节点
     * @param args 二叉树的根节点
     */
    public static void postOrder(TreeNode root) {
        if (root.leftNode != null) {
            postOrder(root.leftNode);
        }
        if (root.rightNode != null) {
            postOrder(root.rightNode);
        }
        if (root != null) {
            System.out.print(root.val);
        }
    }

    /**
     * 层序遍历: 按照从上到下的顺序，先访问根节点，然后依次访问每层的左右子树结点。
     * @param root: 二叉树的根结点
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> qQueue = new ConcurrentLinkedDeque<>();
        if (root != null) {
            // 首先将根节点放入队列
            qQueue.add(root);
        }
        while (!qQueue.isEmpty()) {
            // 打印队列头元素的值
            System.out.print(qQueue.peek().val);
            // 依次放入左右子树结点
            if (qQueue.peek().leftNode != null) {
                qQueue.add(qQueue.peek().leftNode);
            }
            if (qQueue.peek().rightNode != null) {
                qQueue.add(qQueue.peek().rightNode);
            }
            // 将遍历过的元素出列
            qQueue.poll();
        }
    }

    /**
     * 数组的方式层序遍历二叉树
     * 思路: 首先创建一个数组用来保存二叉树的所有结点。
     * 然后令in =0, out=0; in用来标识当前进入的数组中的下标，out表示当前出数组的下标。我们可以这样操作。
     * 遍历当前out元素，将其左右结点依次放入数组in+1, in+2.
     * @param args
     */
    public static void floorOrder(TreeNode root) {
        TreeNode[] listNode = new TreeNode[100];
        int in = 0;
        int out = 0;
        if (root != null) {
            listNode[in++] = root;
        }
        while (in>out){
            System.out.println(listNode[out].val);
            if (listNode[out].leftNode != null) {
                listNode[in++] = listNode[out].leftNode;
            }
            if (listNode[out].rightNode != null) {
                listNode[in++] = listNode[out].rightNode;
            }
            out++;
        }
    }
    public static void main(String[] args) {
	// write your code here
        //
        TreeNode root = init();
//        System.out.println("----------前序遍历-----------");
//        preOrder(root);
//        System.out.println("----------中序遍历------------");
//        inOrder(root);
//        System.out.println("----------后序遍历------------");
//        postOrder(root);
//        System.out.println("---------层序遍历-------------");
//        levelOrder(root);
        System.out.println("---------层序遍历-------------");
        floorOrder(root);

    }
}
