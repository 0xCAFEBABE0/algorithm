package org.example.linked;

import java.util.HashSet;

/**
 * <p>文件名称:org.example.linked.RemoveRepeat</p>
 * <p>文件描述: 单链表删除重复元素</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/12/3
 */
public class RemoveRepeat {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node removeRepeat(Node head) {
        HashSet<Integer> repeat = new HashSet<>();
        Node cur = head;
        Node next = null;
        while (null != cur) {
            repeat.add(cur.value);
            next = cur.next;
            if (null == next) {
                break;
            }
            if (repeat.contains(next.value)) {
                cur.next = next.next;
                next = cur.next;
            }
            cur = next;
        }
        return head;
    }


    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(1, last))));

        Node node = removeRepeat(head);
        while (null != node) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
