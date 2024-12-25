class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9){
            return false;
        }

        for (int row =0; row < 9; row++){ 
            boolean[] rowcheck=new boolean[9];
            for( int col =0;col < 9;col++){
               
                if(board[row][col]!='.'){
                    int x=board[row][col]-'1';
                    if(rowcheck[x]){
                        return false;
                    }
                    rowcheck[x]= true;
                }
            }
        }


        for (int col =0; col < 9; col++){
            boolean[] colcheck=new boolean[9];
            for( int row =0;row < 9;row++){
                
                if(board[row][col]!='.'){
                    int x=board[row][col]-'1';
                    if(colcheck[x]){
                        return false;
                    }
                   colcheck[x]= true;
                }
            }
        }
        for(int block=0;block<9;block++){
        boolean[] gridcheck=new boolean[9];
        for (int row =block/3*3; row < block/3*3+3; row++){
            for( int col =block%3*3;col < block%3*3+3;col++){
               
                if(board[row][col]!='.'){
                    int x=board[row][col]-'1';
                    if(gridcheck[x]){
                        return false;
                    }
                    gridcheck[x]= true;
                }
            }
            }
        }
        return true;
    }
}