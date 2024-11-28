package org.example.linked;

/**
 * <p>文件名称:org.example.linked.Pivot</p>
 * <p>文件描述: pivot划分链表区域 </p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/26
 */
public class Pivot {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private static Node pivot(Node head, int pivot) {
        Node lH = null;
        Node lT = null;
        Node eH = null;
        Node eT = null;
        Node gH = null;

        while (null != head) {
            Node next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (null == lH) {
                    lH = head;
                } else {
                    lT.next = head;
                }
                lT = head;
            } else if (head.value == pivot) {
                if (null == eH) {
                    eH = head;
                } else {
                    eT.next = head;
                }
                eT = head;
            } else if (head.value > pivot) {
                if (null == gH) {
                    gH = head;
                } else {
                    gH.next = head;
                }
            }
            head = next;
        }

        //拼接三个链表
        if (null != lT) {
            head = lH;
            if (null != eH) {
                lT.next = eH;
                if (null != gH) {
                    eT.next = gH;
                }
            } else if (null != gH) {
                lT.next = gH;
            }
        } else {
            if (null != eT) {
                head = eH;
                eT.next = gH;
            } else {
                if (null != gH) {
                    head = gH;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node last = new Node(1, null);
        Node head = new Node(5, new Node(2, new Node(3, new Node(2, last))));

        Node node = pivot(head, 3);
        while (null != node) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
