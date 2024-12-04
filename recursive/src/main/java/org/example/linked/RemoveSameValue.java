package org.example.linked;

import java.util.Stack;

/**
 * <p>文件名称:org.example.linked.RemoveSameValue</p>
 * <p>文件描述: 删除指定值的节点</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/4
 */
public class RemoveSameValue {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 引入额外空间，空间复杂度O(n)，时间复杂度O(n)
     *
     * @param head
     * @param k
     * @return {@link Node }
     */
    private static Node removeWithStack(Node head, int k) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(null != cur) {
            if (cur.value != k) {
                stack.push(cur);
            }
            cur = cur.next;
        }
        //重新链接为链表
        while(!stack.isEmpty()) {
            Node pre = stack.pop();
            pre.next = cur;
            cur = pre;
        }
        return cur;
    }

    /**
     * 原链表遍历，空间复杂度O(1)，时间复杂度O(n)
     * @param head
     * @param k
     * @return {@link Node }
     */
    private static Node removeWithLink(Node head, int k) {
        //定位新的头节点
       while (null != head) {
           if (k != head.value) {
               break;
           }
           head = head.next;
       }
       if (null == head) {
           return head;
       }

       Node cur = head;
       Node next = cur.next;
       while (null != next) {
           if (k == next.value) {
               cur.next = next.next;
           }
           cur = cur.next;
           next = null != cur ? cur.next : null;
       }
       return head;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, last))));

        Node reverse = removeWithLink(head, 2);
        while (null != reverse) {
            System.out.println(reverse.value);
            reverse = reverse.next;
        }
    }
}
