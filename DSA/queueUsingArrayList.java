package DSA;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Queue q=new Queue(9);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.isFull());
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.isFull());
        System.out.println(q.size());
        int ele = q.dequeue();
        System.out.println(ele);
          int ele2 = q.dequeue();
        System.out.println(ele2);
    }
    
}

class Queue{
    
    private int capacity;
    private List<Integer> queue;
    
    Queue(int size){
        this.capacity =size;
        this.queue = new ArrayList<Integer>();
    }
    
    public void enqueue(int ele){
        
        if(isFull()){
            throw new Error("Queue is Full");
        }
        
        this.queue.add(ele);

    }
    
    public int dequeue(){
        int ele=this.queue.get(0);
        this.queue.remove(0);
        return ele;
    }
    
    public boolean isFull(){
        if(this.capacity==this.queue.size()){
            return true;
        }
        return false;
    }
    
    public int size(){
        return this.queue.size();
    }
    
}