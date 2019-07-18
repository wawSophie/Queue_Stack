package Queue;

/**
 * Author:Sophie
 * Created: 2019/7/17
 */

/**
 * 1、头插，出队时间复杂度是O（N），入队时间复杂度O（1）
 * 2、尾插，出队时间复杂度O（1），入队时间复杂度O（N）
 * 链式队列：链表构成的，入队出队都是O（1）
 */

public class TestQueue {

    private Node front;
    private Node rear;
    private int useSize;

    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public TestQueue(){
        this.front=null;
        this.rear=null;
        this.useSize=0;
    }

    //判断队列是否为空
    boolean empty(){
        return useSize==0;
    }

    //返回队首元素，但不出队列
    int peek(){
        if (empty()){
            throw  new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }
    //返回队首元素，并且出队列
    int poll(){
        if (empty()){
            throw  new UnsupportedOperationException("队列为空");
        }
        int data=this.front.data;
        this.front=this.front.next;
        useSize--;
        return data;
    }
    //将item放入队列中
    void add(int item){
        Node node=new Node(item);
        if (front==null){
            this.front=node;
            this.rear=node;
            useSize++;
        }else {
            this.rear.next=node;
            this.rear=this.rear.next;
            useSize++;
        }
    }
    //返回元素个数
    int size(){
        return useSize;
    }

    public static void main(String[] args) {
        TestQueue queue=new TestQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("队列是否为空："+queue.empty());
        System.out.println("队列的大小:"+queue.size());
        System.out.println("队列的队头元素:"+queue.peek());
        System.out.println("队列的队头元素，出栈："+queue.poll());



    }

}
