public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        spiralTraversal(mat);
    }

    public static void spiralTraversal(int[][] mat) {
        int n = mat.length;        // number of rows
        int m = mat[0].length;     // number of cols

        int minr = 0;
        int minc = 0;
        int maxr = n - 1;
        int maxc = m - 1;

        int count = 0;
        int tc = n * m;   // total cells

        while (count < tc) {
            // left wall
            for (int i = minr, j = minc; i <= maxr && count < tc; i++) {
                System.out.println(mat[i][j]);
                count++;
            }
            minc++;

            // bottom wall
            for (int i = maxr, j = minc; j <= maxc && count < tc; j++) {
                System.out.println(mat[i][j]);
                count++;
            }
            maxr--;

            // right wall
            for (int i = maxr, j = maxc; i >= minr && count < tc; i--) {
                System.out.println(mat[i][j]);
                count++;
            }
            maxc--;

            // top wall
            for (int i = minr, j = maxc; j >= minc && count < tc; j--) {
                System.out.println(mat[i][j]);
                count++;
            }
            minr++;
        }
    }
}
