package org.example.linked;

import java.util.Stack;

/**
 * <p>文件名称:org.example.linked.Palindromic</p>
 * <p>文件描述: </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/25
 */
public class Palindromic {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static boolean palindromic_1(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (null != cur) {
            stack.push(cur.value);
            cur = cur.next;
        }

        while(null != head) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 使用半个栈，实现左右对折
     *
     * @param head
     * @return boolean
     */
    private static boolean palindromic_2(Node head) {
        if (null == head.next) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        Node rightHead = head.next;

        while(null != cur.next && null != cur.next.next) {
            rightHead = rightHead.next;
            cur = cur.next.next;
        }

        while(null != rightHead) {
            stack.push(rightHead.value);
            rightHead = rightHead.next;
        }

        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static boolean palindromic_3(Node head) {
        if (null == head.next) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        Node rightHead = head; //右边首个节点
        while(null != cur.next && null != cur.next.next) {
            rightHead = rightHead.next;
            cur = cur.next.next;
        }
        //反转右半边
        Node next = null;
        Node rightCur = rightHead.next;
        rightHead.next = next;
        while(null != rightCur) {
            next = rightCur.next;
            rightCur.next = rightHead;
            rightHead = rightCur;
            rightCur = next;
        }

        while(null != rightHead.next && null != head.next) {
            if (rightHead.value != head.value) {
                return false;
            }
            rightHead = rightHead.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node last = new Node(1, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(2, last))));

        System.out.println(palindromic_3(head));
    }
}
