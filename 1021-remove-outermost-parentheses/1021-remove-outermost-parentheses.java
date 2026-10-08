class Solution {
    public String removeOuterParentheses(String s) {

        int count = 0;
        StringBuilder ans = new StringBuilder();

        for (char ch: s.toCharArray()){

            if(ch == '('){
                count++;
                if(count > 1){
                    ans.append(ch);
                }
            }
            else{
                count--;
                if(count > 0){
                    ans.append(ch);
                }
            }

        }

        return ans.toString();

    }
}