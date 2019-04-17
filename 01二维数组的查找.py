
#解题思路：做这道题首先画图，自然会想到两种对角线的解法，分析出一种不可行之后选择另一种就可以。
#note：注意本题的边界条件

# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, target, array):
        # write code here
        if array == None:
            return false
        row = 0
        col = len(array[0]) - 1
        while row < len(array) and col >= 0:
            if array[row][col] == target:
                return True
            elif array[row][col] < target:
                row += 1
            elif array[row][col] > target:
                col -= 1
        return False