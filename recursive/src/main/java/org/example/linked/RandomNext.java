package org.example.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文件名称:org.example.linked.RandomNext</p>
 * <p>文件描述: 深度复制链表</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/28
 */
public class RandomNext {
    private static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int value, Node next, Node random) {
            this.value = value;
            this.next = next;
            this.random = random;
        }
        public Node(int value) {
            this.value = value;
        }
    }

    private static Node deepCopyUseHash(Node head) {
        Map<Node, Node> copyMapper = new HashMap<>();
        Node cur = head;
        while (null != cur) {
            copyMapper.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while(null != cur) {
            copyMapper.get(cur).next = copyMapper.get(cur.next);
            copyMapper.get(cur).random = copyMapper.get(cur.random);
            cur = cur.next;
        }
        return copyMapper.get(head);
    }

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        first.next = second;
        second.next = third;
        third.next = null;

        first.random = third;
        second.random = first;
        third.random = second;

        Node node = deepCopyUseHash(first);
        while (null != node) {
            System.out.println(node.value);
            System.out.println(node.next != null ? node.next.value : "null");
            System.out.println(node.random != null ? node.random.value : "null");
            node = node.next;
        }
    }

}
