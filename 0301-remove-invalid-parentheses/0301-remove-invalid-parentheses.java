class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        q.add(s);
        set.add(s);

        boolean found = false;

        while(!q.isEmpty()){

            int size = q.size();

            for(int k = 0; k < size; k++){

                String curr = q.poll();

                // check current string is valid
                if(isValid(curr)){
                    ans.add(curr);
                    found = true;
                }

                // if valid string found, dont generate next levels
                if(found) continue;

                // remove 1 parenthesis at a time
                for (int i = 0; i < curr.length(); i++){

                    // remove only '(' or ')'
                    if(curr.charAt(i) != '(' && curr.charAt(i) != ')'){
                        continue;
                    }

                    String next = curr.substring(0,i) + curr.substring(i+1);

                    // avoid duplicate string
                    if(!set.contains(next)){
                        set.add(next);
                        q.add(next);
                    }

                }
            }

            if(found) break;

        }

        return ans;
        
    }

    private boolean isValid(String s){

        int cnt = 0;

        for (char c : s.toCharArray()){

            if(c == '('){
                cnt++;
            }
            else if(c == ')'){
                cnt--;

                if(cnt < 0){
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}