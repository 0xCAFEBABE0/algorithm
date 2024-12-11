package org.example.tree;

/**
 * <p>文件名称:org.example.tree.Traverse</p>
 * <p>文件描述: 二叉树递归遍历</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/9
 */
public class Traverse {
    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //output:[1, 2, 4, 5, 3, 6, 7]
    private static void pre(Node root) {
        if (null == root) {
            return;
        }
        System.out.println(root.value);
        pre(root.left);
        pre(root.right);
    }

    //output:[4, 2, 5, 1, 6, 3, 7]
    private static void mid(Node root) {
        if (null == root) {
            return;
        }
        mid(root.left);
        System.out.println(root.value);
        mid(root.right);
    }

    //output:[4, 5, 2, 6, 7, 3, 1]
    private static void post(Node root) {
        if (null == root) {
            return;
        }
        post(root.left);
        post(root.right);
        System.out.println(root.value);
    }

    /**
     *      1
     *    /   \
     *   2     3
     *  / \   / \
     * 4   5  6  7
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1
                , new Node(2, new Node(4, null, null), new Node(5, null, null))
                , new Node(3, new Node(6, null, null), new Node(7, null, null)));
        post(root);
    }
}
