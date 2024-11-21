package org.example.stack;

import java.util.List;
import java.util.Stack;

/**
 * <p>文件名称:org.example.stack.SortStack</p>
 * <p>文件描述: 栈排序</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/7
 */
public class SortStack {

    private static void sort(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!helper.isEmpty() && helper.peek() < cur) {
                stack.push(helper.pop());
            }
            helper.push(cur);
        }

        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(3, 1, 5, 4, 2));
        sort(stack);
        System.out.println(stack);
    }
}
