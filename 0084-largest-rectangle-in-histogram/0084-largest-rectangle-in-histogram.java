import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] NSG = FindNSGArray(heights, n);
        int[] PSG = FindPSGArray(heights, n);

        // for (int i = 0; i < n; i++){
        //     System.out.print(NSG[i] +" ");
        //     // System.out.print(PSG[i] +" ");
        // }
        // System.out.println();
        // for (int i = 0; i < n; i++){
        //     System.out.print(PSG[i] +" ");
        // }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int width = NSG[i] - PSG[i] - 1;
            int area = heights[i] * width;
            ans = Math.max(ans, area);
        }

        return ans;
    }

    public int[] FindNSGArray(int[] heights, int n) {
        int[] NSG = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0; i--){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }

            NSG[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return NSG;
        
    }

    public int[] FindPSGArray(int[] heights, int n) {
        int[] PSG = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            PSG[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
            
        }

        return PSG;
    }
}