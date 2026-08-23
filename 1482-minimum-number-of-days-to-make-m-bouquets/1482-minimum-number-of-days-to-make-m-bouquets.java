class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int max = 0;
        int min = 0;

        for (int i = 0; i < bloomDay.length; i++){
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        int l = min;
        int r = max;

        int ans = -1;

        while(l <= r){

            int mid = l + (r-l) / 2;

            if(check(bloomDay, m, k, mid)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return ans;
        
    }

    private boolean check(int[] arr, int m, int k, int day){

        int curr = 0;
        int flower = k;

        for (int i = 0; i < arr.length; i++){

            if(day >= arr[i]){
                flower--;
                if(flower == 0){
                    curr++;
                    flower = k;
                }
            }
            else{
                flower = k;
            }

            if(curr >= m) return true;

        }

        return false;
    }
}