import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ls = leftSmallerIndex(heights);
         int[] rs = rightSmallerIndex(heights);
         int max = 0 ;
         for(int i = 0 ; i< heights.length;i++){
            int area =( rs[i] - ls[i] -1 ) * heights[i];
            if(max < area ){
                max = area;
            }
         }
         return max;
        
    }
    public static int[] rightSmallerIndex(int[] arr){ // finding tbe next smaller element index on right side       
    int[] rs = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    for(int i = arr.length - 1 ; i >= 0 ; i-- ){
        while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            rs[i] = arr.length;// if there is no smaller element on right side then we will take the length of array
        } else {
            rs[i] = st.peek();
        }
        st.push(i);// push index of the element
    }
    return rs;
}

    public static int[] leftSmallerIndex(int[] arr){// finding tbe next smaller element index on left side
    int[] ls = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < arr.length; i++ ){
        while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            ls[i] = -1;// if there is no smaller element on left side then we will take -1
        } else {
            ls[i] = st.peek();// index of next smaller element on left side
        }
        st.push(i);//   push index of the element
    }
    return ls;
}

}