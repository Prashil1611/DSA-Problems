class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++){

            boolean flag = true;

            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++){

                if(strs[j].length() <= i || strs[j].charAt(i) != c){
                    flag = false;
                    break;
                }


            }

            if(flag) ans.append(c);
            else break;

        }

        return ans.toString();

        
    }
}