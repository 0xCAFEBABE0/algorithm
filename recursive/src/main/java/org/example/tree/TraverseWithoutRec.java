package org.example.tree;

import java.util.Stack;

/**
 * <p>文件名称:org.example.tree.TraverseWithoutRecu</p>
 * <p>文件描述: 不使用递归的二叉树遍历</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/10
 */
public class TraverseWithoutRec {
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

    private static void preWithRec(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node head = stack.pop();
            System.out.println(head.value);

            if (null != head.right) {
                stack.push(head.right);
            }
            if (null != head.left) {
                stack.push(head.left);
            }
        }
    }

    private static void midWithRec(Node root) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || null != root) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
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
        midWithRec(root);
    }
}
