package org.example.linked;

import java.util.Stack;

/**
 * <p>文件名称:org.example.linked.SumNode</p>
 * <p>文件描述: 链表施行加法操作</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/29
 */
public class SumNode {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static int sum(Node h1, Node h2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(null != h1) {
            s1.push(h1.value);
            h1 = h1.next;
        }
        while(null != h2) {
            s2.push(h2.value);
            h2 = h2.next;
        }

        int ca = 0;
        int cnt = 0;
        int res = 0;
        while(!s1.isEmpty() || !s2.isEmpty()) {
            int re = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + ca;
            ca = re / 10;
            res += (re % 10) * (int) Math.pow(10, cnt++);
        }
        if (1 == ca) {
            res += ca * (int) Math.pow(10, cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node h1 = new Node(1, new Node(2, new Node(3, new Node(2, last))));

        Node h2 = new Node(9, new Node(2, new Node(3, new Node(9, null))));
        System.out.println(sum(h1, h2));
    }
}
