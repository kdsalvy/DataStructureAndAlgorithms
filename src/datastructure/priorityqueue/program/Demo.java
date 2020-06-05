package datastructure.priorityqueue.program;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo {

    public static void main(String[] args) {
        Comparator<Integer> compareInDescOrder = (i, j) -> -i.compareTo(j); 
        PriorityQueue<Integer> pQ = new PriorityQueue<>(compareInDescOrder);
        Integer[] intArray = {2,4,5,7,8,1,3,6,9,0};
        
        for(Integer integer: intArray) {
            pQ.offer(integer);
        }
        
        while(!pQ.isEmpty()) {
            System.out.print(pQ.poll() + " ");
        }        
    }
}
