package Stack;

import java.util.Stack;

/**
 * Author:Sophie
 * Created: 2019/7/18
 */

/**
 * 最小栈：每次去栈内取元素，都可以拿到当前栈内最小的元素
 * pop的时候要注意：1、若stack和minstack的栈顶元素相同，则同时出栈，否则，知识stack出栈
 *              2、getMin从minStack中获得栈顶元素，top从stack中获得栈顶元素
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            if (x<=minStack.peek()){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())){
            stack.pop();
            minStack.pop();
        }else {
            stack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        MinStack minStack=new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
