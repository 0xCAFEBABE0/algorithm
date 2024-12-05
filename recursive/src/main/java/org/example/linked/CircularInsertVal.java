package org.example.linked;

/**
 * <p>文件名称:org.example.linked.CircularInsertVal</p>
 * <p>文件描述: 环形升序链表，插入指定值后，仍然保持有序</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/5
 */
public class CircularInsertVal {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    private static Node insert(Node head, int k) {
        Node newNode = new Node(k, null);
        Node pre = head;
        Node cur = head.next;

        while(head != cur) {
            if (pre.value <= k && k <= cur.value) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;

        return newNode.next == head && k <= cur.value ? newNode : head;
    }

    public static void main(String[] args) {
        Node last = new Node(6, null);
        Node head = new Node(1, new Node(2, new Node(4, new Node(5, last))));
        last.next = head;

        Node node = insert(head, 3);
        do {
            System.out.println(node.value);
            node = node.next;
        } while (head != node);
    }

}
