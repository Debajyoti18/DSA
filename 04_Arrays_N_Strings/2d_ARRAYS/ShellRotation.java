public class ShellRotation {
     public static void main(String[] args) {
        int[][] mat = {
            {11, 12, 13, 14, 15, 16},
            {21, 22, 23, 24, 25, 26},
            {31, 32, 33, 34, 35, 36},
            {41, 42, 43, 44, 45, 46},
            {51, 52, 53, 54, 55, 56},
            {61, 62, 63, 64, 65, 66}
        };

        int s = 2; // shell number (1 = outermost)
        int r = 3; // rotation count

        rotateShell(mat, s, r);
        display(mat);
    }

     private static void display(int[][] mat) {

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++ ){
                System.out.println(mat[i][j]);
            }
        }

    }

     private static void rotateShell(int[][] mat, int s, int r) {
       int[] oned = shellToArray(mat,s);
       rotate(oned,r);
       fillShellFromOned(mat,s,oned);
     }

     private static void rotate(int[] oned, int r) {
        r = r % oned.length;
        if( r < 0) r = r + oned.length;
       reverse(oned, 0 , oned.length - r -1 );
       reverse(oned, oned.length - r , oned.length -1 );
       reverse(oned , 0 , oned.length -1 );

    }

     private static void reverse(int[] oned, int i, int j) {
        int li  = 0 ;
        int hi = oned.length - 1 ;

        while( li < hi ){
            int x = oned[li];
            oned[li] = oned[hi];
            oned[hi] = x;
            
            li++;
            hi--;
        }

    }

     private static void fillShellFromOned(int[][] mat, int s, int[] oned) {
        
       int minr = s -1;
        int minc = s -1 ;
        int maxr = mat.length -s ;
        int maxc = mat[0].length -1;

        int id = 0;
        //left
        for(int i = minr ; i <= maxr ; i++){
            mat[i][minc] = oned[id++];
        }
        //bottom
        for(int i = minc + 1 ; i <= maxc ; i++){
            mat[maxr][i] = oned[id++];
        }
        //right
        for(int j = maxr - 1; j >= minr ; j--){
            mat[j][maxc]  = oned[id++];
        }
        //top
        for(int j = maxc - 1; j >= minc ; j--){
           mat[minr][j] = oned[id++];
        }
        

    }

     private static int[] shellToArray(int[][] mat, int s) {
        int minr = s -1;
        int minc = s -1 ;
        int maxr = mat.length -s ;
        int maxc = mat[0].length -1;

        int size = 2 * (maxr - minr + maxc - minc );
        int[] oned = new int[size];
        int idx = 0;

        //for left 
        for(int  i = minr ; i <= maxr ; i++){
            oned[idx++] = mat[i][minc];
        }
        //bottom
        for(int i = minc + 1 ; i <= maxc ; i++){
            oned[idx++] = mat[maxr][i];
        }
        //right
        for(int j = maxr - 1; j >= minr ; j--){
            oned[idx++] = mat[i][maxc];
        }
        //top
        for(int j = maxc - 1; j >= minc ; j--){
            oned[idx++] = mat[minr][j];
        }
        return oned;
     }

}
