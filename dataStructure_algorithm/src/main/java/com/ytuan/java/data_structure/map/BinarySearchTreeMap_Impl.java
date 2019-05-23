package com.ytuan.java.data_structure.map;

public class BinarySearchTreeMap_Impl<K extends Comparable<K>, V> implements Map_interface<K, V> {

    private TreeNode root;

    private int size;

    public BinarySearchTreeMap_Impl() {

        this.root = null;

        this.size = 0;
    }

    private TreeNode getNode(K key) {
        return getNode(root, key);
    }

    private TreeNode getNode(TreeNode root, K key) {


        if (root == null ||key.compareTo(root.key) == 0 )
            return root;
        else if (key.compareTo(root.key) < 0)
            return getNode(root.left, key);
        else if (key.compareTo(root.key) > 0)
            return getNode(root.right, key);

        return null;
    }

    @Override
    public void add(K key, V value) {

        root = add(root, key, value);
    }

    private TreeNode add(TreeNode root, K key, V value) {

        if (root == null) {
            size++;
            root = new TreeNode(key, value);
        } else if (key.compareTo(root.key) < 0)
            root.left = add(root.left, key, value);
        else if (key.compareTo(root.key) > 0)
            root.right = add(root.right, key, value);
        else
            root.value = value;

        return root;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {

        TreeNode node = getNode(key);

        if (node != null)
            return node.value;

        return null;
    }

    @Override
    public void set(K key, V newValue) {

        TreeNode node = getNode(key);

        if (node != null)
            node.value = newValue;
        else
            throw new IllegalArgumentException("the map does not exists this key!!!");

    }

    private TreeNode getMinNode(TreeNode root) {

        if (root.left == null)
            return root;

        return getMinNode(root.left);
    }

    private TreeNode removeMin(TreeNode root) {

        if (root.left == null) {

            TreeNode rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }

        root.left = removeMin(root.left);
        return root;
    }

    private TreeNode getMaxNode(TreeNode root) {

        if (root.right == null)
            return root;

        return getMaxNode(root);
    }

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
    public V remove(K key) {

        TreeNode node = getNode(key);


        if (node != null) {
            root = remove(root, key);
            return node.value;
        } else
            return null;
    }

    /**
     * @param root
     * @param key
     * @return 返回删除指定key后的根节点
     */
    private TreeNode remove(TreeNode root, K key) {

        if (key.compareTo(root.key) < 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            root.right = remove(root.right, key);
            return root;
        } else {  // key.compareTo(root.key) == 0

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

                TreeNode result = getMaxNode(root.left);
                result.left = removeMax(root.left);
                result.right = root.right;

                root.left = root.right = null;

                return result;

            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class TreeNode {

        K key;

        V value;

        TreeNode left;
        TreeNode right;

        public TreeNode(K key, V value) {

            this.key = key;

            this.value = value;

            this.left = null;

            this.right = null;
        }

        public TreeNode() {
            this(null, null);
        }
    }
}
