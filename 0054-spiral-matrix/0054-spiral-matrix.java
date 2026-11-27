class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int statRow = 0;
        int statCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while(statRow <= endRow && statCol <= endCol){

            for (int j = statCol; j <= endCol; j++){
                ans.add(matrix[statRow][j]);
            }

            for (int i = statRow + 1; i <= endRow; i++){
                ans.add(matrix[i][endCol]);
            }

            for (int j = endCol - 1; j >= statCol; j--){
                if(statRow == endRow) break;
                ans.add(matrix[endRow][j]);
            }

            for (int i = endRow - 1; i >= statRow + 1; i--){
                if(statCol == endCol) break;
                ans.add(matrix[i][statRow]);
            }

            statRow++;
            endRow--;
            statCol++;
            endCol--;

        }

        return ans;
        
    }
}