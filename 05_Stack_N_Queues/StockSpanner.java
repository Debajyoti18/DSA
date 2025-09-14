import java.util.ArrayList;
import java.util.Stack;

class Pair{
    int price , span;
    Pair(int x , int y){
        this.price = x;
        this.span =  y;
    }
} 
public class StockSpanner {
    static Stack<Pair> stack     = new Stack<>();;
    public static void main(String[] args) {
    int stocks[] = {100, 80, 40, 60, 32, 96, 123};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <  stocks.length ; i++){
            list.add(findStockSpan(stocks[i]));
        }
        System.out.println(list);
        
    }
    private static Integer findStockSpan(int currentPrice) {
         
          int span = 1;
          while( !stack.isEmpty() &&  stack.peek().price <= currentPrice){
            span += stack.pop().span;
          }
          stack.push(new Pair(currentPrice, span));
          return span;
    }
}
