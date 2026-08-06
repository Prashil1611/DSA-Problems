class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0;
        int len = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for (int r = 0;r < s.length(); r++){

            char ch = s.charAt(r);

            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            while((r-l+1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            len = Math.max(len, r-l+1);

        }

        return len;

    }
}