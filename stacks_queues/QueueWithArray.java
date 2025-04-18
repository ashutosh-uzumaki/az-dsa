package stacks_queues;

import java.io.*;

public class QueueWithArray {
class Queue {
    int[] arr;
    int front;
    int rear;

    Queue(){
        arr = new int[(int) 1e6 + 1];
        front = -1;
        rear = -1;
    }

    void add(int val){
        if(rear + 1 < arr.length){
            ++rear;
            arr[rear] = val;
            if(front == -1) front = 0;
        }
    }

    void remove(){
        if(front == -1 || front > rear){
            return;
        }
        ++front;
    }

    void print(){
        if(front == -1 || front > rear){
            System.out.println(0);
        } else {
            System.out.println(arr[front]);
        }
    }
}

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        while(testCases > 0){
            Queue q = new Queue();
            int queries = Integer.parseInt(reader.readLine());
            while(queries > 0){
                String[] tokens = reader.readLine().split(" ");
                String ops = tokens[0];
                int value = 0;
                if(ops.equals("add")){
                    value = Integer.parseInt(tokens[1]);
                }

                switch(ops){
                    case "add": q.add(value);
                                break;
                    case "print": q.print();
                                break;
                    case "remove": q.remove();
                                break;
                    default: System.out.println("Invalid operation");
                }
                queries -= 1;
            }
            testCases -= 1;
        }
    }
}
}
