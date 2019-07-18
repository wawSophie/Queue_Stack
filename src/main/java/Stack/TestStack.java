package Stack;

/**
 * Author:Sophie
 * Created: 2019/7/17
 */

/**
 * 栈是依靠数组实现的，实现顺序栈和实现顺序表是一样的
 */
public class TestStack {

    //依赖数组实现，top是当前可以存放数据元素的下标
    private int[] elem;
    private int top;
    private int usesize;

    public TestStack(int size){
        this.elem=new int[size];
        this.top=0;
        this.usesize=0;
    }

    //将item压入栈中,先判断是否满了
    void push(int item) {
        if (isFull()) {
            throw new UnsupportedOperationException("栈满了");
        }
        elem[top] = item;
        top++;
        usesize++;

    }

    private boolean isFull() {
        return this.top==this.elem.length;
    }

    //返回栈顶元素，并且出栈，先判断是否是空的
    int pop(){
        if (empty()){
            throw  new UnsupportedOperationException("栈是空的");
        }
        int result=elem[top-1];
        top--;
        usesize--;
        return result;
    }


    //返回栈顶元素，但不出栈
    int peek(){
        if (empty()){
            throw  new UnsupportedOperationException("栈是空的");
        }
        return  elem[top-1];
    }
    //判读这个栈是否为空栈
    boolean empty(){
        if (top==0){
            return true;
        }else {
            return false;
        }

    }

    //返回元素个数
    int size(){
        return top;
    }




    public static void main(String[] args) {
        TestStack stack=new TestStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("栈是否为空："+stack.empty());//false
        System.out.println("返回栈顶元素，不出栈："+stack.peek());//3
        System.out.println("返回栈顶元素，出栈："+stack.pop());//3
        System.out.println("栈中元素的个数："+stack.size());//2

    }
}
