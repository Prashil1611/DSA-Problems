class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        helper("", 0, 0, n, ans);

        return ans;

    }

    public static void helper(String partial_ans, int open, int close, int n, List<String> ans){

        if(partial_ans.length() == 2 * n){
            ans.add(partial_ans);
            System.out.print(partial_ans +" "); // std 0/p
            return;
        }

        if(open < n){
            helper(partial_ans + '(', open+1, close, n, ans);
        }

        if(close < open){
            helper(partial_ans + ')', open, close+1, n, ans);
        }
    }
}