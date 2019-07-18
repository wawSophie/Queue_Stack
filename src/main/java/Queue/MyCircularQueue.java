package Queue;

/**
 * Author:Sophie
 * Created: 2019/7/17
 */
public class MyCircularQueue {

    private int front;
    private int rear;
    private int usesize;
    private int[] elem;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.elem=new int[k];
        this.front=0;
        this.rear=0;
        this.usesize=0;
    }
    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()){
            throw  new UnsupportedOperationException("队列满了");
        }
        elem[rear]=value;
        //要注意这里，不能直接++，有可能越界了，比如front在1，rear在6，length=7，则还可以再向后走，可是不能直接++
        this.rear=(this.rear+1)%this.elem.length;
        this.usesize++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()){
            throw new UnsupportedOperationException("队列为空");
        }
        this.front=(this.front+1)%this.elem.length;
        this.usesize--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()){
            throw  new UnsupportedOperationException("队列为空");
        }
        return elem[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()){
            throw  new UnsupportedOperationException("队列为空");
        }
        int index=  this.rear==0? this.elem.length-1:this.rear-1;
        return elem[index];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.front==this.rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (rear+1)%this.elem.length==front;
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

