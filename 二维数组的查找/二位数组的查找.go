/*
解题思路：做这道题首先画图，自然会想到两种对角线的解法，分析出一种不可行之后选择另一种就可以。
note：注意本题的边界条件
*/
package main

import "fmt"

func Find(matrix [][]int, number int)  bool{
	rows := len(matrix)
	columns := len(matrix[0])

	row := 0
	column := columns -1
	found := false

	if matrix != nil && rows > 0 && columns >0{
		for row < rows && column >= 0{
			if matrix[row][column] == number{
				found = true
				break
			}else if number < matrix[row][column]{
				column--
			}else if number > matrix[row][column]{
					row++
			}
		}
	}
	return found
	
}
//测试用例，由于没有网络编译器可以测试
func main()  {
	matrix := [][]int{
		{1, 2, 8, 9},
		{2, 4, 9, 12},
		{4, 7, 10, 13},
		{6, 8, 11, 15},
	}
	for i := 0; i < 15; i++{
		fmt.Printf("find %d :%v\n", i, Find(matrix, i))
	}

}