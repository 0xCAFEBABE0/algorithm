package org.example.linked;

/**
 * <p>文件名称:org.example.linked.RemoveLastKth</p>
 * <p>文件描述: 单链表，删除倒数第k个元素</p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
 * @version 1.0
 * @since 2024/11/20
 */
public class RemoveLastKth {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node removeLastKth(Node head, int k) {
        Node cur = head;
        while(null != cur.next) {
            cur = cur.next;
            --k;
        }
        if (k > 0) {
            return head;
        }
        if (k == 0) {
            return head.next;
        }

        cur = head;
        while(k < 0) {
            cur = cur.next;
            ++k;
        }
        cur.next = cur.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node last = new Node(5, null);
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, last))));

        Node node = removeLastKth(head, 2);
        while (null != node) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
