public class SumOfArrays {
    public static void main(String[] args) {
        int[] a = {9, 9, 9};
        int[] b = {1};
        addArray(a, b);
    }

    public static void addArray(int[] a, int[] b) {
        int i = a.length - 1;
        int j = b.length - 1;
        int carry = 0;

        int maxLength = Math.max(a.length, b.length);
        int[] res = new int[maxLength + 1]; // +1 for potential carry
        int k = res.length - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digitA = i >= 0 ? a[i] : 0;
            int digitB = j >= 0 ? b[j] : 0;

            int sum = digitA + digitB + carry;
            res[k] = sum % 10;
            carry = sum / 10;

            i--;
            j--;
            k--;
        }

        // Skip leading zero if not used
        int start = res[0] == 0 ? 1 : 0;

        for (int m = start; m < res.length; m++) {
            System.out.print(res[m]);
        }
        System.out.println();
    }
    
}
