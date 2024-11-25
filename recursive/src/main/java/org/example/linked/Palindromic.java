package org.example.linked;

import java.util.Stack;

/**
 * <p>文件名称:org.example.linked.Palindromic</p>
 * <p>文件描述: </p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
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

    public static void main(String[] args) {
        Node last = new Node(1, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(2, last))));

        System.out.println(palindromic_1(head));
    }
}
