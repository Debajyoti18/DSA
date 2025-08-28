public class SameBaseAddition {

    public static void main(String[] args) {
         int result = getSum(8, 236, 754);
        System.out.println(result); // should print 1212 (base 8)
    }
    public static int getSum(int b ,int n1 ,int n2){
        int res = 0, carry = 0 , p = 1;
        while (n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 /= 10;
            n2 /= 10;
             int add = d1 + d2 + carry ;
             int x = add % b;
             carry  = add / b;
              res += x * p;     
              p = p * 10;

        }
        return res;
    }
}