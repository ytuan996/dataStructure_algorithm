package com.ytuan.java.data_structure.binarySearchTree;

import com.ytuan.java.data_structure.queue.LoopArrayQueue_Impl;
import com.ytuan.java.data_structure.queue.Queue_interface;
import com.ytuan.java.data_structure.stack.ArrayStack_Impl;
import com.ytuan.java.data_structure.stack.Stack_interface;

public class BinarySearchTree_Impl<E extends Comparable<E>> implements BinarySearchTree_interface<E> {

    private TreeNode root;

    private int size;

    public BinarySearchTree_Impl() {

        this.root = null;

        this.size = 0;
    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public void add(E element) {

        root = add(root, element);
    }

    private TreeNode add(TreeNode root, E element) {

        if (root == null) {
            size++;
            return new TreeNode(element);
        } else {
            if (element.compareTo(root.val) < 0)
                root.left = add(root.left, element);
            else if (element.compareTo(root.val) > 0)
                root.right = add(root.right, element);
        }
        return root;
    }

    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(TreeNode root, E element) {

        if (root == null)
            return false;

        if (element.compareTo(root.val) == 0)
            return true;
        else if (element.compareTo(root.val) < 0)
            return contains(root.left, element);
        else
            return contains(root.right, element);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {

        if (root == null)
            return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrderNormal() {

        if (root == null)
            return;

        // 测试一下自己实现的栈
        Stack_interface<TreeNode> stack = new ArrayStack_Impl<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();

            System.out.println(curNode.val);

            if (curNode.right != null)
                stack.push(curNode.right);
            if (curNode.left != null)
                stack.push(curNode.left);
        }
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode root) {

        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    @Override
    public void levelOrder() {

        if (root == null)
            return;

        Queue_interface<TreeNode> queue = new LoopArrayQueue_Impl<>();

        queue.enqueue(root);
        while (!queue.isEmpty()) {

            TreeNode curNode = queue.dequeue();

            System.out.println(curNode.val);

            if (curNode.left != null)
                queue.enqueue(curNode.left);
            if (curNode.right != null)
                queue.enqueue(curNode.right);
        }
    }

    @Override
    public E minElement() {
        return getMinNode(root).val;
    }

    private TreeNode getMinNode(TreeNode root) {

        if (root.left == null)
            return root;

        return getMinNode(root.left);
    }

    @Override
    public E maxElement() {
        return getMaxNode(root).val;
    }

    private TreeNode getMaxNode(TreeNode root) {

        if (root.right == null)
            return root;
        return getMaxNode(root.right);
    }

    @Override
    public E removeMinElement() {

        E result = minElement();
        root = removeMin(root);
        return result;
    }

    private TreeNode removeMin(TreeNode root) {

        if (root.left == null) {
            TreeNode rightNode = root.right; // 暂存root为根的最小节点的右节点
            root.right = null; // 删除右节点的引用
            size--;
            return rightNode; // 返回删除之后的右节点
        }
        root.left = removeMin(root.left);
        return root;
    }

    @Override
    public E removeMaxElement() {

        E result = maxElement();
        root = removeMax(root);
        return result;
    }

    /**
     * 删除以root为根节点的二分搜素树的最大值
     *
     * @param root 二分搜索树的根节点
     * @return 删除最大值之后的二分搜索树的根
     */
    private TreeNode removeMax(TreeNode root) {

        if (root.right == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            size--;
            return leftNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    @Override
    public void removeElement(E element) {
        root = removeElement(root, element);
    }

    private TreeNode removeElement(TreeNode root, E element) {

        if (element.compareTo(root.val) < 0) {
            root.left = removeElement(root.left, element);
            return root;
        } else if (element.compareTo(root.val) > 0) {
            root.right = removeElement(root.right, element);
            return root;
        } else {  // element.compareTo(root.val) == 0

            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                size--;
                return rightNode;
            } else if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                size--;
                return leftNode;
            } else {

                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                TreeNode successor = getMinNode(root.right);
                successor.right = removeMin(root.right);
                successor.left = root.left;

                root.left = root.right = null;

                return successor;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(TreeNode node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    private class TreeNode {

        E val;

        TreeNode left;

        TreeNode right;

        public TreeNode(E val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(E val) {
            this(val, null, null);
        }

        public TreeNode() {
        }
    }
}
