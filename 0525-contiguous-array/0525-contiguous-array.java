class Solution {
    public int findMaxLength(int[] nums) {

        int n = nums.length;

        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;

        for (int i = 0; i < n; i++){
            
            if(nums[i] == 0){
                sum -= 1;
            }
            else{
                sum += 1;                
            }

            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
            
        }

        return maxLength;

        // for (int i = 0; i < n; i++){

        //     int zero = 0;
        //     int one = 0;
        //     int length = 0;

        //     for (int j = i; j < n; j++){

        //         if(nums[j] == 0){
        //             zero++;
        //         }
        //         else{
        //             one++;
        //         }

        //         if(zero == one){
        //             length = j-i+1;
        //         }
        //     }

        //     maxLength = Math.max(maxLength, length);

        // }

        // return maxLength;
        
    }
}