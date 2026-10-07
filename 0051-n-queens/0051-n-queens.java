class Solution {
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();

        helper(0, board, ans);

        return ans;
        
    }

    private void helper(int row, char[][] board, List<List<String>> ans){

        if(row == board.length){

            List<String> tmp = new ArrayList<>();

            for (int i = 0; i < board.length; i++){
                tmp.add(new String(board[i]));
            }

            ans.add(tmp);

            return;
        }

        for (int j = 0; j < board.length; j++){

            if(isSafe(row, j, board)){
                board[row][j] = 'Q';
                helper(row + 1, board, ans);
                board[row][j] = '.';
            }

        }
    }

    private boolean isSafe(int row, int col, char[][] board){

        // check up
        for (int i = row-1; i >= 0; i--){
            if(board[i][col] == 'Q') return false;
        }

        // check left
        for (int j = col-1; j >= 0; j--){
            if(board[row][j] == 'Q') return false;
        }

        // check left up digonal
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // check right up digonal
        for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}