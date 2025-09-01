public class WaveTraversal {
    public static void main(String[] args) {
         int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        waveTraversal(mat);
    }

    private static void waveTraversal(int[][] mat) {
        int n = mat.length -1;
        int m = mat[0].length -1;
        for(int j = 0 ; j <= m ;j++){
            if(j % 2 == 0){
                for(int i = 0 ; i <= n ;i++){
                    System.out.println(mat[i][j]);
                }
            }else{
                for(int i = n ; i >= 0 ;i--){
                    System.out.println(mat[i][j]);
                }
            }
        }
    }
}
