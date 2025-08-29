public class SubstractionOfArrays {
    public static void main(String[] args) {
        int[] a = {1, 0, 0, 0};  // Minuend
        int[] b = {1};           // Subtrahend
        substractArray(a, b);
    }

    public static void substractArray(int[] a, int[] b) {
        int i = a.length - 1;
        int j = b.length - 1;
        int borrow = 0;

        int maxLength = Math.max(a.length, b.length);
        int[] res = new int[maxLength];  // No need for +1 in subtraction
        int k = res.length - 1;

        while (k >= 0) {
            int val1 = i >= 0 ? a[i] : 0;  // From 'a' (the bigger number)
            int val2 = j >= 0 ? b[j] : 0;  // From 'b' (smaller number)

            int diff;
            if (val1 + borrow >= val2) {
                diff = val1 + borrow - val2;
                borrow = 0;
            } else {
                diff = val1 + borrow + 10 - val2;
                borrow = -1;
            }

            res[k] = diff;

            i--;
            j--;
            k--;
        }

        // Skip leading zeros
        int index = 0;
        while (index < res.length - 1 && res[index] == 0) {
            index++;
        }

        for (int st = index; st < res.length; st++) {
            System.out.print(res[st]);
        }
        System.out.println();
    }
}
