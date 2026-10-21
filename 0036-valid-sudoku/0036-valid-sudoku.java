class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 1st find the empty spaces and store its position on emptyList list

        List<int[]> emptyList = new ArrayList<>();

        for (int i = 0; i < 9; i++){
            
            for (int j = 0; j < 9; j++){
                
                if(board[i][j] == '.') continue;

                char d = board[i][j];
                board[i][j] = '.';

                if(!isSafe(i, j, board, d)){
                    board[i][j] = d;
                    return false;
                }
                
                board[i][j] = d;

            }
        }

        return true;

    }


    private boolean isSafe(int r, int c, char[][] board, char d){

        // check column
        for (int j = 0; j < 9; j++){
            if(board[r][j] == d) return false;
        }

        // check row
        for (int i = 0; i < 9; i++){
            if(board[i][c] == d) return false;
        }

        // check 3*3 grid
        int lr = (r/3) * 3;
        int lc = (c/3) * 3;

        for (int i = lr; i < lr+3; i++){
            for (int j = lc; j < lc+3; j++){
                if(board[i][j] == d) return false;
            }
        }

        return true;
    }
}