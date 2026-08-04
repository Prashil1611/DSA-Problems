class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> st = new Stack<>();
        int maxCount = 0;

        st.push(-1);
        
        for (int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else{

                if(!st.isEmpty()) st.pop();

                if(st.isEmpty()) {
                    st.push(i);
                }else{
                    maxCount = Math.max(maxCount, i - st.peek());
                }
            }
        }

        return maxCount;
    }

//     class Solution {
//     public int longestValidParentheses(String s) {

//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1); // Base index for calculating length

//         int maxLength = 0;

//         for (int i = 0; i < s.length(); i++) {

//             if (s.charAt(i) == '(') {
//                 stack.push(i);
//             } else {

//                 stack.pop();

//                 // No matching '('
//                 if (stack.isEmpty()) {
//                     stack.push(i); // Current ')' becomes the new base
//                 } else {
//                     // Valid substring length
//                     maxLength = Math.max(maxLength, i - stack.peek());
//                 }
//             }
//         }

//         return maxLength;
//     }
// }
}