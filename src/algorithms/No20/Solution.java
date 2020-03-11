package algorithms.No20;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char idx = s.charAt(i);
            if (map.containsKey(idx)) {
                char c = stack.isEmpty() ? '#' : stack.pop();
                if (c != map.get(idx)) return false;//开闭符号一定是相邻的，即当前开符号，下一个一定是当前的闭符号
            } else {
                stack.push(idx);
            }
        }
        return stack.isEmpty();//判断是否为空，不为空表示还有符号没有闭合
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){}[]]"));
    }
}
