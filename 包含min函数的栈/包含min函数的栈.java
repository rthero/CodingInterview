import java.util.Stack;

public class Solution {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(int node) {
        dataStack.push(node);
        if (minStack.empty()) {
            minStack.push(node);
        }else if (node <= minStack.peek()) {
            minStack.push(node);
        }

    }

    public void pop() {
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();


    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
        return minStack.peek();

    }
}