public class RotateBy90 {
    public static void main(String[] args) {
         int[][] mat = {
            {11, 12, 13, 14, 15, 16},
            {21, 22, 23, 24, 25, 26},
            {31, 32, 33, 34, 35, 36},
            {41, 42, 43, 44, 45, 46},
            {51, 52, 53, 54, 55, 56},
            {61, 62, 63, 64, 65, 66}
        };

        transpose(mat);
        ratate90(mat);
        display(mat);

    }
    private static void display(int[][] mat) {
        for(int i = 0; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
               System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
       
    }
    //transpose of the matrix
    public static int[][] transpose(int[][] mat){
        for(int i = 0; i < mat.length ; i++){
            for(int j = i ; j < mat[0].length ; j++){
                int x = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = x;
            }
        }
        return mat;
    }
    //revresing columns 1 with last and so on
    public static int[][] ratate90(int[][] mat){
        for(int i =0 ;i < mat[0].length ; i++){
        int low = 0 , high = mat.length - 1 ;
        while (low < high) {
            int temp = mat[i][low];
            mat[i][low] = mat[i][high];
            mat[i][high] = temp;

             low++;
             high--;

        }
        
      }
      return mat;
    }
}
