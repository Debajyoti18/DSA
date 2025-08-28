public class AnybaseAddition {
    public static void main(String[] args) {
        
    }
    public static int getSum(int b,int n1,int n2){
        int res =0, carry = 0, p = 1;
        while (n1 > 0 || n2 > 0 || carry > 0) {
        int d1 = n1 % 10;
        int d2 = n2 % 10;
        n1 = n1 /10 ;
        n2 = n2 /10 ;

        int add = d1 + d2 + carry ;

       add = add % b;//remainer is used in the result
       carry = add / b;//quoscent act as the next carry
        
       res += add * p;
       p = p * 10;
        }
        return res;

    }
}
