
/**
 * @Project_Name: Java programming course in school
 * @Package_Name: PACKAGE_NAME
 * @File: Q5.java
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Created: 2023-10-27 20:40
 * @Last_Modified: 2023-10-27 20:40
 * @Description: The sixth experiment at school. This is a binary class.
 */

import java.util.*;
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree<T> {
    private TreeNode<T> root;
    private final Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        if (comparator.compare(data, node.data) < 0) {
            node.left = insert(node.left, data);
        }

        if (comparator.compare(data, node.data) > 0) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root, 1);
    }

    private void preOrderTraversal(TreeNode<T> node, int index) {
        if (node != null) {
            System.out.print(" -> [Pos$" + index + "]" + node.data);
            preOrderTraversal(node.left, 2 * index);
            preOrderTraversal(node.right, 2 * index + 1);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root, 1);
    }

    private void inOrderTraversal(TreeNode<T> node, int index) {
        if (node != null) {
            inOrderTraversal(node.left, 2 * index);
            System.out.print(" -> [Pos$" + index + "]" + node.data);
            inOrderTraversal(node.right, 2 * index + 1);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root, 1);
    }

    private void postOrderTraversal(TreeNode<T> node, int index) {
        if (node != null) {
            postOrderTraversal(node.left, 2 * index);
            postOrderTraversal(node.right, 2 * index + 1);
            System.out.print(" -> [Pos$" + index + "]" + node.data);
        }
    }

    public List<List<T>> levelOrderTraversal() {
        if (root == null) {
            throw new RuntimeException("Empty!");
        }

        List<List<T>> result = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<T> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                level.add(node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }


    public int getNodeNumber() {
        return getNodeNumber(root);
    }

    private int getNodeNumber(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return getNodeNumber(node.left) + getNodeNumber(node.right) + 1;
    }

    public int getLeafNodeNumber() {
        return getLeafNodeNumber(root);
    }

    private int getLeafNodeNumber(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return getLeafNodeNumber(node.left) + getLeafNodeNumber(node.right);
    }

    public int getLevelNodeNumber(int level) {
        return getLevelNodeNumber(root, level);
    }

    private int getLevelNodeNumber(TreeNode<T> node, int level) {
        if (node == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        }

        return getLevelNodeNumber(node.left, level - 1) + getLevelNodeNumber(node.right, level - 1);
    }

    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public void deleteNode(T data) {
        root = deleteNode(root, data);
    }

    private TreeNode<T> deleteNode(TreeNode<T> node, T data) {
        if (node == null) {
            throw new RuntimeException("Not Found!");
        }

        if (comparator.compare(data, node.data) == 0) {
            if (node.left == null && node.right == null) {
                return null;
            }

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            T min = getMin(node.right);
            node.data = min;
            node.right = deleteNode(node.right, min);
            return node;
        }

        if (comparator.compare(data, node.data) < 0) {
            node.left = deleteNode(node.left, data);
            return node;
        }

        node.right = deleteNode(node.right, data);
        return node;
    }

    private T getMin(TreeNode<T> node) {
        return node.left == null ? node.data : getMin(node.left);
    }

    public boolean searchNode(T data) {
        return searchNode(root, data);
    }

    private boolean searchNode(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (comparator.compare(data, node.data) == 0) {
            return true;
        }

        return searchNode(node.left, data) || searchNode(node.right, data);
    }
}

public class Q5 {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(Integer::compareTo);

        for (int i : new int[]{88, 55, 66, 22, 11, 33, 99, 77}) {
            tree.insert(i);
        }

        System.out.print("Pre-Order Traversal: ");
        tree.preOrderTraversal();
        System.out.println();

        System.out.print("In-Order Traversal: ");
        tree.inOrderTraversal();
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        tree.postOrderTraversal();
        System.out.println();

        List<List<Integer>> levelOrderResult = tree.levelOrderTraversal();
        System.out.println("Level Order Traversal: " + levelOrderResult);

        System.out.println("Number Of Node Number: " + tree.getNodeNumber());

        System.out.println("Number Of Leaf Node: " + tree.getLeafNodeNumber());

        System.out.println("Node At Level 2: " + tree.getLevelNodeNumber(2));

        System.out.println("Tree Depth: " + tree.getDepth());

        tree.deleteNode(99);
        System.out.print("Delete data 99: ");
        tree.preOrderTraversal();
        System.out.println();

        System.out.println("Search data 55: " + tree.searchNode(55));
    }
}
