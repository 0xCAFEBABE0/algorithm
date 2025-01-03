package org.example.str;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>文件名称:org.example.str.Deformation</p>
 * <p>文件描述: 两个字符串互为变形词</p>
 * <p>内容摘要: </p>
 * <p>其他说明: </p>
 *
 * @version 1.0
 * @since 2025/1/3
 */
public class Deformation {
    private static boolean isDeformation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> mapper = new HashMap<>();
        char[] s1CharArray = s1.toCharArray();
        for (char c : s1CharArray) {
            if (!mapper.containsKey(c)) {
                mapper.put(c, 1);
            } else {
                mapper.put(c, mapper.get(c) + 1);
            }
        }

        char[] s2CharArray = s2.toCharArray();
        for (char c : s2CharArray) {
            if (!mapper.containsKey(c)) {
                return false;
            }
            mapper.put(c, mapper.get(c) - 1);
            if (mapper.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isDeformation("123", "213"));
    }
}
