package Stack;

/**
 * Author:Sophie
 * Created: 2019/7/17
 */

import java.util.Stack;

/**
 * 括号匹配,leetcode
 */
public class BracketsMatch {
    public static void main(String[] args) {

    }
    public boolean isValid(String s){
        int i=0;
        Stack<Character>  stack=new Stack<>();
        for (i=0;i<s.length();i++){
            //当前字符是左括号，则入栈
            if (s.charAt(i)=='{' || s.charAt(i)=='[' ||
                    s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else {
                //当前字符不是左括号,则不入栈，和栈顶元素去比较
                //如果栈为空，说明右括号多
                if (stack.empty()){
                    System.out.println("右括号多");
                    return false;
                }else {
                    //栈不为空，进行比较，若相等，则栈顶元素出栈，否则说明括号次序不匹配
                    char temp=stack.peek();
                    if ((temp=='(' && s.charAt(i)==')' )
                            || (temp=='{' && s.charAt(i)=='}')
                            || (temp=='[' && s.charAt(i)==']')){
                        stack.pop();
                    }else {
                        System.out.println("括号次序不匹配");
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()){
            System.out.println("左括号多");
            return false;
        }else {
            return true;
        }
    }
}

//class Stack{
//    //依赖数组实现，top是当前可以存放数据元素的下标
//    private char[] elem;
//    private int top;
//    private int usesize;
//
//    public Stack(int size){
//        this.elem=new char[size];
//        this.top=0;
//        this.usesize=0;
//    }
//
//    //将item压入栈中,先判断是否满了
//    void push(char item) {
//        if (isFull()) {
//            throw new UnsupportedOperationException("栈满了");
//        }
//        elem[top] = item;
//        top++;
//        usesize++;
//
//    }
//
//    private boolean isFull() {
//        return this.top==this.elem.length;
//    }
//
//    //返回栈顶元素，并且出栈，先判断是否是空的
//    int pop(){
//        if (empty()){
//            throw  new UnsupportedOperationException("栈是空的");
//        }
//        int result=elem[top-1];
//        top--;
//        usesize--;
//        return result;
//    }
//
//
//    //返回栈顶元素，但不出栈
//    int peek(){
//        if (empty()){
//            throw  new UnsupportedOperationException("栈是空的");
//        }
//        return  elem[top-1];
//    }
//    //判读这个栈是否为空栈
//    boolean empty(){
//        if (top==0){
//            return true;
//        }else {
//            return false;
//        }
//
//    }
//
//    //返回元素个数
//    int size(){
//        return top;
//    }
//
//}
