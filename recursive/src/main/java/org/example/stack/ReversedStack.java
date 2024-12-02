package org.example.stack;

import java.util.List;
import java.util.Stack;

/**
 * <p>文件名称:org.example.stack.ReversedStack</p>
 * <p>文件描述: 栈反转，递归不占用额外空间</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2024/11/6
 */
public class ReversedStack {

    private static Integer getAndRemoveLast(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            Integer last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reversed(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer last = getAndRemoveLast(stack);
        reversed(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(1, 2, 3));
        System.out.println(stack);
        reversed(stack);
        //System.out.println(getAndRemoveLast(stack));
        System.out.println(stack);
    }
}
