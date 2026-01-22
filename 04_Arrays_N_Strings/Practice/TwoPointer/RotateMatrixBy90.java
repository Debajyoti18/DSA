class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n; j++){
                // Swapping elements to transpose the matrix prevent overwriting
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }
        for(int i = 0 ; i < n ; i++){
            //  Reversing each row
            int s =0, e = n-1;
            while(s < e){
                int temp = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = temp;
                s++;
                e--;
            }
        }
    }
}