class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int[] freq = new int[n*n];

        for (int i = 1; i <= n*n; i++){
            freq[i-1] = i; 
        }

        int twice = 0;
        int missing = 0;

        for (int i = 0; i < n; i++){

            for (int j = 0; j < n; j++){

                int num = grid[i][j];

                if(freq[num-1] != 0){
                    freq[num-1] = 0;
                }
                else if(freq[num-1] == 0){
                    twice = num;
                }
                
            }
        }

        for (int i = 0; i < n*n; i++){
            if(freq[i] != 0){
                missing = freq[i];
                break;
            }
        }

        return new int[]{twice, missing};


        

        
    }
}