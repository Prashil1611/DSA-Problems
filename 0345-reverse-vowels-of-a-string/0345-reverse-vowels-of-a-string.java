class Solution {
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        int j = s.length() - 1;

        while(i < j){

            if(Vowel(s.charAt(i)) && Vowel(s.charAt(j))){
                char tmp = s.charAt(i);
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, tmp);
                i++;
                j--;
            }
            
            if(!Vowel(s.charAt(i))) i++;
            if(!Vowel(s.charAt(j))) j--;

        }

        return sb.toString();

    }

    private boolean Vowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}