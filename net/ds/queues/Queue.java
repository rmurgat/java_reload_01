package net.ds.queues;

public class Queue {
    final int MAX = 30; 
    int[] queue = new int[MAX];
    int head=0;
    int rear=0;
    int counter = 0;

    public void push(int value) {
        if(counter==MAX) {
            System.out.println(" * QUEUE is FULL !");
            return;
        } else {
            if(rear==MAX) rear = 0;
        }    
        queue[rear++] = value;
        counter++;
    }

    public int pop() {
        if(head==MAX) head=0;
        counter--;
        return queue[head++];
    }

    public String toString() {
        String res = "";
        res += "[head:] " + head;
        res += " [rear:] " + rear;
        res += " [total:] " + counter;
        res += " [values:] "; 

        int i = head;
        while(i<MAX) {
            res += (head==i?"S ":"") + queue[i] + (rear-1==i?" E":"") + ", ";
            i++;
        }
         if(rear<=head) {
            i = 0;
            while(i<rear) {
                res += (head==i?"S ":"") + queue[i] + (rear-1==i?" E":"") + ", ";
                i++;
            }
        } 
        return res;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.printf("\n0. Queue { %s }", queue.toString());

        for(int i=1; i<35; i++) queue.push(i);

        System.out.printf("\n1. Queue { %s }", queue.toString());

        for(int i=1; i<25; i++) queue.pop();

        System.out.printf("\n2. Queue { %s }", queue.toString());

        for(int i=50; i<80; i++) queue.push(i);
        
        System.out.printf("\n3. Queue { %s }", queue.toString());
        for(int i=1; i<10; i++) queue.pop();        

        System.out.printf("\n4. Queue { %s }", queue.toString());

        for(int i=150; i<280; i++) queue.push(i);

        System.out.printf("\n5. Queue { %s }", queue.toString());
    }
}
