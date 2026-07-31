class Solution {

    class Result{
        int ans = 0;
    }

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        Result res = new Result();
        
        helper(0, board, res);

        return res.ans;
        
    }

    private void helper(int row, char[][] board, Result res) {

        if(row == board.length) {
            res.ans++;
            return;
        }


        for (int j = 0; j < board.length; j++) {

            if(isSafe(row, j, board)){
                board[row][j] = 'Q';
                helper(row + 1, board, res);
                board[row][j] = '.';
            }

        }

    }

    private boolean isSafe(int row, int col, char[][] board) {

        // check up
        for (int i = row - 1; i >= 0; i--){
            if(board[i][col] == 'Q') return false;
        }

        // check left
        for (int j = col - 1; j >= 0; j--){
            if(board[row][j] == 'Q') return false;
        }

        // check left up diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // check right up diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;

    }
}