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
