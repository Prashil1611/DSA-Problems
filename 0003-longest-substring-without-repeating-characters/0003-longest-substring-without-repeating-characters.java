class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int maxLength = 1;

        for (int r = 0; r < s.length(); r++){

            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));

            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
        
    }
}