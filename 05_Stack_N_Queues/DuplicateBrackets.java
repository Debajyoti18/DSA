import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        String exp = "((a+b)+(c+d))";
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < exp.length() ; i++){
            char ch = exp.charAt(i);
            if(  ch == ')'){
                if(stack.peek() == '('){
                   flag = true;
                }else{
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();   //pop the duplicate 
                }
                
            }else{
                stack.push(ch);
            }
            
        }
        if(flag){
             System.out.println("Yes Duplicate brackets found!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }else{
        System.out.println("No Duplicate Brackets found!!!!!!!!!!!!!!!!!");
        }

    }
}
