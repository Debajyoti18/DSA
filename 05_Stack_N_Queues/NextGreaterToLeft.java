import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {12,32223,6534,98,123,5543,755};
        System.out.println("Next Greater element to left of elements are :");
       ArrayList<Integer> li = findNextLeft(arr);
       System.out.println(li);
        ArrayList<Integer> list = findNextSmallerToLeft(arr);
             System.out.println("Next smaller element to left of elements are :");
             System.out.println(list);
    }

    private static ArrayList<Integer> findNextLeft(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> li = new ArrayList<>();
            for(int i = 0 ; i  < arr.length ; i++ ){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){ //pop until greater is found 
                    stack.pop();
                }
                if(stack.isEmpty()){//if  empty then no greater to left
                    li.add(-1);
                }else{
                    li.add(stack.peek());// top is the required left greater
                }
                stack.push(arr[i]);
            }
            
            return li;
            
    }

    private static ArrayList<Integer> findNextSmallerToLeft(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> li = new ArrayList<>();
            for(int i = 0 ; i  < arr.length ; i++ ){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){ //pop until smaller is found 
                    stack.pop();
                }
                if(stack.isEmpty()){//if  empty then no smaller to left
                    li.add(-1);
                }else{
                    li.add(stack.peek());// top is the required left greater
                }
                stack.push(arr[i]);
            }
            
            return li;
            
    }
}
