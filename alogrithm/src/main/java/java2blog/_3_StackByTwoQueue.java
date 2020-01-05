package java2blog;

import java.util.LinkedList;
import java.util.Queue;

public class _3_StackByTwoQueue {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    _3_StackByTwoQueue()
    {
        queue1=new LinkedList<Integer>();
        queue2=new LinkedList<Integer>();
    }


    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public void push(int i){
        if(queue1.size()==0)
            queue1.add(i);
        else{
            int sizeOfQueue1 = queue1.size();
            // Copy elements of Queue1 to Queue2
            for(int j=0 ; j<sizeOfQueue1 ; j++)
                queue2.add(queue1.remove());
            queue1.add(i);
            // Copy elements for Queue2 to Queue1
            for(int k=0 ; k<sizeOfQueue1 ; k++)
                queue1.add(queue2.remove());
        }
    }

    public int pop(){
        if(queue1.size()==0)
            throw new IllegalArgumentException("Underflow Exception");
        return queue1.remove();
    }

}
