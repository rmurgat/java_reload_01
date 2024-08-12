package net.ds.stacks;

public class Stack {
    int[] stack = new int[10];
    int idx = 0;

    public void push(int value) {
        stack[idx++]=value;
    }
    public int pop() {
        if(idx==0) return -1;
        return stack[--idx];
    }

    public String toString() {
        String res="";
        for(int i=0; i<idx; i++) {
            res += Integer.toString(stack[i]) + ",";
        }
        return res;
    }

    public static void main(String[] arg) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stack.push(5);

        System.out.printf("Stack:[ %s ]", stack);

        for(int i=0; i<10; i++) {
            int ipop = stack.pop();
            System.out.printf("Head: %d", ipop);   
        }
        System.out.printf("Stack:[ %s ]", stack);
    }

}
