
/*
* 解决这种问题时一定要画图帮助理解，把边界坐标都注明，这样分析边界条件时也好操作
* 本题在剑指 offer上有另外一种思路，但那种思路有技巧，不甚明晰
* 个人觉得下述代码似更好些 
* 
* */
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        // 定义圈数loops
        int loops = (Math.min(row, col) + 1) / 2;
        for (int i = 0; i < loops; i++) {
            for (int m = i; m <= col - 1 - i; m++) {
                // 这里的m之所以要多减1，是因为数组的下标是从0开始的
                list.add(matrix[i][m]);
            }
            for (int n = i + 1; n <= row - 1 - i; n++) {
                // 这里的i+1是因为考虑到圈数，n需要减去起始的第一个元素，在前一个循环时已经访问过了
                list.add(matrix[n][col - 1 - i]);
                // 这里应该特别注意坐标以及边界情况，第一次做的时候就是在这一步把坐标搞反了，所以排很长时间错
            }
            for (int o = col - 2 - i; (o >= i) && (row - i - 1 != i); o--) {
                list.add(matrix[row - 1 - i][o]);
            }
            for (int p = row - 2 - i; (p > i) && (col - i - 1 != i); p--) {
                list.add(matrix[p][i]);
            }

        }
        return list;

    }
}
