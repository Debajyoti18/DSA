import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String exp = "[((a+b)+(c+d))]";
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                    stack.push(ch);
        }else if (ch == ')'){
            boolean val = checkParenthesis(stack, '(');
                if(!val){
                    System.out.println(val);
                }
        }else if ( ch == '}'){
            boolean val = checkParenthesis(stack, '{');
                if(!val){
                    System.out.println(val);
                }

        }else if(ch == ']'){
                boolean val = checkParenthesis(stack, '[');
                if(!val){
                    System.out.println(val);
                }
        }else{

        }

    }
       if(stack.isEmpty()){
            System.out.println("Balanced!!!!!!!!!!!!!!");
        }else{
            System.out.println("Not Balanced!!!!!!!!!!!!!!!!!!!!");
        }
    }

    
    public static boolean checkParenthesis(Stack<Character> st , char ch){
        if(st.isEmpty()){
            return false;
        }else if(st.peek() != ch){
            return false;
        }else{
            st.pop();
            return true;
        }
    }
}
//Valid Parenthesis
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                 char c = stack.pop();
                if((ch == ')' && c != '(') ||(ch == ']' && c != '[') ||(ch == '}' && c != '{')){
                    return false;
                }
            
            }
        }
        return stack.isEmpty();
    }
}