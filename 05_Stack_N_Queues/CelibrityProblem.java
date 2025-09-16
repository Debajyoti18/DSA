 /* A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.
 A square matrix mat[][] of size n*n is used to represent people at the party such that if an element of row i and column j is set
  to 1 it means ith person knows jth person.You need to return the index of the celebrity in the party, 
  if the celebrity does not exist, return -1.
  */

import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < mat.length ; i++ ){
            st.push(i);
        }
        while( st.size() >= 2){
            int  i = st.pop();
            int j = st.pop();
            if(mat[i][j] == 1){// i knows j so i cannot be celebrity
                st.push(j);// j can be celebrity
            }else{
                st.push(i);// j cannot be celebrity
            }
    
        }
        int exp = st.pop();
        for(int i = 0; i< mat.length;i++){
            if(i != exp){  // for all other people check if they know exp and exp does not know them
                if( mat[i][exp]==0  || mat[exp][i] == 1){// if any one of these condition fails then exp is not celebrity
                    return -1;
                }
            }
        }
        return exp;
    }
}