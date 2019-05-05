import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean flag = false;
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return flag;
        }
        Stack<Integer> stack = new Stack<>();
        int indexOFpopA = 0;
        //这里的思路主要是：从题目给的两个例子可以推断出判断的规律是：
        //如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列就不可能是一个弹出序列。
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[indexOFpopA]) {
                stack.pop();
                ++ indexOFpopA;
                //注意这里最后一个值pop后，index仍会+1，故而虽然index是从0开始的，但是最后值会和popA的长度一致，而不是减一
            }
        }
        if (stack.empty() && indexOFpopA  == popA.length ) {
            flag = true;
        }
        return flag;
    }
}