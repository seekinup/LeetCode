package algorithms.No155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int top = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
       stack.push(x);
       if(min.isEmpty() || min.peek() <= x){
           min.push(x);
       }
    }

    public void pop() {
        if(stack.isEmpty()) return;

        Integer pop = stack.pop();
        if(pop == min.peek()){
            min.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()) return Integer.MAX_VALUE;

        Integer pop = stack.pop();
        if(pop == min.peek()){
            min.pop();
        }
        return pop;
    }

    public int getMin() {

        return min.isEmpty() ? Integer.MAX_VALUE : min.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(3343);
        minStack.pop();
        System.out.println(minStack.top);
        System.out.println(minStack.getMin());
    }
}
