class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()){

            if(c == '('){
                st.push(0);
            }
            else{
                int val = st.pop();
                int total = (val == 0) ? 1 : 2 * val;
                st.push(st.pop() + total);
            }

        }

        return st.pop();
        
    }
}