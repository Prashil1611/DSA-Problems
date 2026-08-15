class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> ans = new ArrayList<>();
        int i = 0;

        for (int num = 1; num <= n && i < target.length; num++){

            ans.add("Push");

            if(num != target[i]){
                ans.add("Pop");
            }
            else{
                i++;
            }
        }

        return ans;

    }
}