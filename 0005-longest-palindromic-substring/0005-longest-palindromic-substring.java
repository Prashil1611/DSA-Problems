class Solution {
    public String longestPalindrome(String s) {

        if(s.length() <= 1) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++){

            // odd length
            int l1 = expand(s, i, i);

            // even length
            int l2 = expand(s, i, i+1);

            int len = Math.max(l1, l2);

            if(len > end - start + 1){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }

        return s.substring(start, end + 1);

    }

    private int expand(String s, int i, int j){

        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return j - i - 1;

    }
}