package org.example.linked;

/**
 * <p>文件名称:org.example.linked.TwoHead</p>
 * <p>文件描述: 两个有序链表，打印公共部分</p>
 * <p>版权所有: Copyright(C)2019-2022</p>
 * <p>公司: 趣店集团 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @author <a> href="mailto:chenrong@qudian.com">chen</a>
 * @version 1.0
 * @since 2024/11/19
 */
public class TwoHead {
    private static class Node {
        public int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private static void twoHead(Node h1, Node h2) {
        while (null != h1.next || null != h2.next) {
            if (h1.value < h2.value) {
                h1 = h1.next;
            } else if (h1.value > h2.value) {
                h2 = h2.next;
            } else {
                System.out.println(h1.value);
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);

        Node h2 = new Node(2);
        h2.next = new Node(3);
        h2.next.next = new Node(5);
        twoHead(h1, h2);
    }


}
