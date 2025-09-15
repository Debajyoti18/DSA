import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String exp = "2+6*4/8-3";
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

       for(int i  = 0 ; i < exp.length() ; i++ ){
        char ch = exp.charAt(i);
        if(ch == '('){
            operators.push(ch);

        }else if(Character.isDigit(ch)){
            operands.push(ch-'0');

        }else if (ch == ')'){
            
                while(operators.peek() != '('){
                    char op = operators.pop();
                    int v2 = operands.peek() - '0';
                    int v1 = operands.pop() - '0';
                    int val = operation(v1,v2,op);
                    operands.push(val);
                }
                operators.pop();// remove the opening bracket also 
        }else{
            
        }
       }
        
    }
}
