class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;;

        for (int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        int l = 1;
        int r = max;
        int ans = max;

        while(l <= r){

            int mid = l + (r-l) / 2;

            if(check(piles, h, mid)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return ans;
        
    }

    private boolean check(int[] arr, int h, int speed){

        int hr = 0;

        for (int i = 0; i < arr.length; i++){

            // hr += (arr[i] + speed - 1) / speed;

            if(arr[i] < speed) hr += 1;
            else if(arr[i] % speed != 0) hr += 1;

            hr += arr[i] / speed;

            if(hr > h) return false;

        }

        return true;
    }
}