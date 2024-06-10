/*
 * @FileName: null.java
 * @Description: null.java
 *
 * @Version: 1.0.0
 * @Author: zhangjiangh03
 * @Date: 2023-10-08 19:35
 */

public class MyBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    private TreeNode root;

    public MyBinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = insertNode(current.left, val);
        } else if (val > current.val) {
            current.right = insertNode(current.right, val);
        }

        return current;
    }

    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNode current, int val) {
        if (current == null) {
            return false;
        }
        if (val == current.val) {
            return true;
        } else if (val < current.val) {
            return searchNode(current.left, val);
        } else {
            return searchNode(current.right, val);
        }
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    private TreeNode deleteNode(TreeNode current, int val) {
        if (current == null) {
            return null;
        }

        if (val == current.val) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                int minValue = findMinValue(current.right);
                current.val = minValue;
                current.right = deleteNode(current.right, minValue);
            }
        } else if (val < current.val) {
            current.left = deleteNode(current.left, val);
        } else {
            current.right = deleteNode(current.right, val);
        }
        return current;
    }

    private int findMinValue(TreeNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }


}


class testMyBinaryTree {
    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(2);
        binaryTree.insert(10);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(45);
        binaryTree.insert(8);
        binaryTree.delete(3);

        System.out.println(binaryTree.search(5));
    }
}
