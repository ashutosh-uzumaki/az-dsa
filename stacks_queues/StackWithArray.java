package stacks_queues;

import java.io.*;

public class StackWithArray {

class Stack{
    int[] arr;
    int top;
    Stack(){
        arr = new int[(int)1e6];
        top = -1;
    }

    void add(int num){
        if(top + 1  < arr.length){
             top++;
            arr[top] = num;
        }
    }

    void remove(){
        if(top != -1){
            top -= 1;
        }
    }

    void print(){
        if(top != -1){
            System.out.println(arr[top]);
        }else{
            System.out.println(0);
        }
    }


}
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        while(testCases > 0){
            Stack st = new Stack();
            int queries = Integer.parseInt(reader.readLine());
            while(queries > 0){
                String[] tokens = reader.readLine().split(" ");
                String ops = tokens[0];
                int value = 0;
                if(ops.equals("add")){
                    value = Integer.parseInt(tokens[1]);
                }

                switch(ops){
                    case "add": st.add(value);
                                break;
                    case "remove": st.remove();
                                break;
                    case "print": st.print();
                                break;
                    default: System.out.println("Not a valid operation");
                                break;
                }
                queries -= 1;
            }
            testCases -= 1;
        }
    }
}
}
