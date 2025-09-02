public class DigonalTraversal {
    public static void main(String[] args) {
        int[][] mat = {
            {11, 12, 13, 14, 15, 16},
            {21, 22, 23, 24, 25, 26},
            {31, 32, 33, 34, 35, 36},
            {41, 42, 43, 44, 45, 46},
            {51, 52, 53, 54, 55, 56},
            {61, 62, 63, 64, 65, 66}
        };
        PrintdigonalTraversal(mat);
    }

    private static void PrintdigonalTraversal(int[][] mat) {
       for(int i = 0; i< mat.length ;i++){
        //diffrence j-k =i always
        for( int j = 0, k = i; k < mat.length ; j++ ,k++){//j & k moves downwards
            System.out.println(mat[j][k]);
        }
       }
    }
}
