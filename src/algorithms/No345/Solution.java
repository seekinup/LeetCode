package algorithms.No345;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static String reverseVowels(String s) {
        if(s.length() < 2) return s;//不同编译环境下，结果为空会返回"\u0000" 或者 null

        ArrayList<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];

        while (i <= j) {
            char head = s.charAt(i), tail = s.charAt(j);
            if (!vowels.contains(head)) result[i++] = head;
            if (!vowels.contains(tail)) result[j--] = tail;
            if (vowels.contains(head) && vowels.contains(tail) && i <= j) {
                result[i++] = tail;
                result[j--] = head;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {

        System.out.println(reverseVowels("Aa."));
    }
}
