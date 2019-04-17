/*
解题思路：做这道题首先画图，自然会想到两种对角线的解法，分析出一种不可行之后选择另一种就可以。
note：注意本题的边界条件
*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int columns = array[0].length();
        boolean flag = false;
        if(array != null && rows > 0 && columns >0){
            int row = 0;
            int col = columns -1;
            while(row < rows && col >= 0){  //注意这个地方col是可以等于0的
                if(array[row][col] == target){
                    flag = true;
                    break;
                }else if(array[row][col] > target){
                    col--;
                }else if(array[row][col] < target){
                    row++;
                }
            }
        }
        return flag;
    }
}