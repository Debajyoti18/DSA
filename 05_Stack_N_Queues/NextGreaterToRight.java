import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {12,33,65,98,123,5543,755};
        System.out.println("Next Greater element to right of elements are :");
       ArrayList<Integer> li = findNextRight(arr);
       System.out.println(li);
    }

    private static ArrayList<Integer> findNextRight(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> li = new ArrayList<>();
            for(int i = arr.length - 1; i >= 0; i--){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){ //pop until greater is found 
                    stack.pop();
                }
                if(stack.isEmpty()){//if  empty then no greater to right
                    li.add(-1);
                }else{
                    li.add(stack.peek());// top is the required right greater
                }
                stack.push(arr[i]);
            }
            Collections.reverse(li);
            return li;
            
    }
}
