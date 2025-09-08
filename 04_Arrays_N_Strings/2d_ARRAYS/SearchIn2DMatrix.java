public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] mat = {
            {11, 12, 13, 14, 15, 16},
            {21, 22, 23, 24, 25, 26},
            {31, 32, 33, 34, 35, 36},
            {41, 42, 43, 44, 45, 46},
            {51, 52, 53, 54, 55, 56},
            {61, 62, 63, 64, 65, 66}
        };
        System.out.println(" The index of the element " + 52 + " is at : " );
        printMatrixElement(mat, 52);
    }
    public static void printMatrixElement(int[][] mat , int x){
        int i = 0 , j = mat[0].length - 1; //start from right corner 
        while ( i < mat.length && j >= 0){
            if( x == mat[i][j]){ 
                System.out.println(i + "," + j);
                return;
            }else if(x <  mat[i][j]){ // if less hai then by moving left as matrix have smaller elements as that of x
                j--;
            }else{   //if greater then go down 
                    i++;
            }
        } 
    }
}
