package Stack;

import java.util.Stack;

/**
 * Author:Sophie
 * Created: 2019/7/18
 */

/**
 * 两个栈实现一个队列
 * 先进后出 ->先进先出
 * 注意事项：1、栈要注意pop之后要将元素再放原来的栈中，否则顺序就变了  2、定义的变量要注意是否已经被更改
 */
class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty() && stack2.isEmpty()){
            stack1.push(x);
        }else {
            if (!stack1.isEmpty()){
                stack1.push(x);
            }
            if (!stack2.isEmpty()){
                stack2.push(x);
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack1.isEmpty()){
            int count=stack1.size();
            while (count>1){
                stack2.push(stack1.pop());
                count--;
            }
            int result=stack1.peek();
            stack1.pop();
            int i=1;
            count=stack1.size();
            while (i<count){
                stack1.push(stack2.pop());
                i++;
            }
            return result;
        }

        if (!stack2.isEmpty()){
            int count=stack2.size();
            while (count>1){
                stack1.push(stack2.pop());
                count--;
            }
            int result=stack2.peek();
            stack2.pop();
            int i=1;
            count=stack2.size();
            while (i<count){
                stack2.push(stack1.pop());
                i++;
            }
            return result;
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (!stack1.isEmpty()){
            int count=stack1.size();
            while (count>1){
                stack2.push(stack1.pop());
                count--;
            }
            int result=stack1.peek();
            int i=1;
            count=stack1.size();
            while (i<count){
                stack1.push(stack2.pop());
                i++;
            }
            return result;
        }

        if (!stack2.isEmpty()){
            int count=stack2.size();
            while (count>1){
                stack1.push(stack2.pop());
                count--;
            }
            int result=stack2.peek();
            int i=1;
            count=stack2.size();
            while (i<count){
                stack2.push(stack1.pop());
                i++;
            }
            return result;
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
//        System.out.println(queue.pop());
    }
}
