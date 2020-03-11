package algorithms.No118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
        for (List<Integer> integers : generate) {
            System.out.println(integers);
        }
    }

}
