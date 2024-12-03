package org.example.linked;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * <p>文件名称:org.example.linked.ReverseEachKth</p>
 * <p>文件描述: k个一组翻转单链表</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/3
 */
public class ReverseEachKth {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node revertEachKth(Stack<Node> stack, Node pre, Node next) {
        Node p = stack.peek();
        if (null != pre) {
            pre.next = p;
        }
        while(!stack.isEmpty()) {
            p = stack.pop();
            p.next = !stack.isEmpty() ? stack.peek() : next;
        }
        return p;
    }

    private static Node reverse(Node head, int k) {
        if (1 >= k) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node next = null;
        Node cur = head;
        Node newHead = new Node(-1, null);

        while (null != cur) {
            next = cur.next;
            stack.push(cur);
            if (null == pre) {
                newHead = cur;
            }
            if (k == stack.size()) {
                pre = revertEachKth(stack, pre, next);
            }
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, last))));

        Node reverse = reverse(head, 2);
        while (null != reverse) {
            System.out.println(reverse.value);
            reverse = reverse.next;
        }
    }
}
