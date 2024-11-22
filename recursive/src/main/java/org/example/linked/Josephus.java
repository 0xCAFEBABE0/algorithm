package org.example.linked;

/**
 * <p>文件名称:org.example.linked.Josephus</p>
 * <p>文件描述: 约瑟夫环</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/22
 */
public class Josephus {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private static Node kill(Node head, int k) {
        int count = 0;
        while(head != head.next) {
            if (k - 2 == count) {
               head.next = head.next.next;
               count = 0;
            } else {
                ++count;
            }
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, last))));
        last.next = head;

        Node reverse = kill(head, 3);
        System.out.println(reverse.value);
    }
}
