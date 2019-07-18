package Stack;

/**
 * Author:Sophie
 * Created: 2019/7/18
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列模拟一个栈
 * 队列中offer和add的区别，两者都是向队尾插入元素，
 * 不同的是，当超出队列界限的时候，add()方法是抛出异常，offer()方法是返回false
 */
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList();
        queue2=new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.offer(x);
        }else {
            if (!queue1.isEmpty()){
                queue1.offer(x);
            }
            if (!queue2.isEmpty()){
                queue2.offer(x);
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()){
            int count=queue1.size();
            while (count>1){
                queue2.offer(queue1.poll());
                count--;
            }
            int result=queue1.peek();
            queue1.poll();
            return result;
        }
        if (!queue2.isEmpty()){
            int count=queue2.size();
            while (count>1){
                queue1.offer(queue2.poll());
                count--;
            }
            int result=queue2.peek();
            queue2.poll();
            return result;
        }
        return -1;
    }

    /** Get the top element. */
    public int top() {
        if (!queue1.isEmpty()){
            int count=queue1.size();
            while (count>1){
                queue2.offer(queue1.poll());
                count--;
            }
            int result=queue1.peek();
            queue2.offer(queue1.poll());
            return result;
        }
        if (!queue2.isEmpty()){
            int count=queue2.size();
            while (count>1){
                queue1.offer(queue2.poll());
                count--;
            }
            int result=queue2.peek();
            queue1.offer(queue2.poll());
            return result;
        }
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()){
            return true;
        }
        return false;
    }
}
