package org.example.linked;

/**
 * <p>文件名称:org.example.linked.Reverse</p>
 * <p>文件描述: 反转单链表</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/21
 */
public class Reverse {

    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;

        while(null != cur) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, last))));

        Node reverse = reverse(head);
        while (null != reverse) {
            System.out.println(reverse.value);
            reverse = reverse.next;
        }
    }
}
