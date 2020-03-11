package algorithms.No415;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public static String addStrings(String num1, String num2) {
        Stack<Integer> stack = new Stack<>();
        int carry = 0, q = '0';
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {

            int x = i < 0 ? 0 : num1.charAt(i) - q;
            int y = j < 0 ? 0 : num2.charAt(j) - q;

            int sum = x + y + carry;
            carry = sum / 10;
            stack.push(sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            stack.push(carry);
        }
        System.out.println("栈深度=" + stack.size());

        char[] result = new char[stack.size()];
        for (int k = 0; !stack.isEmpty(); k++) {
            result[k] = (char) (stack.pop() + q);
        }
        return new String(result);

    }


    /**
     * 使用StringBuilder和 反转求解
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {//定义两个指针分别接收两个字符串的长度
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("15", "79"));
    }
}
