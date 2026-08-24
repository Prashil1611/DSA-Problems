class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[256];
        for (char ch : t.toCharArray()){
            freq[ch]++;
        }

        int l = 0;
        int start = 0;
        int count = t.length();
        int length = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++){

            char ch = s.charAt(r);

            if(freq[ch] > 0){
                count--;
            }

            freq[ch]--;

            while(count == 0){

                if(r - l + 1 < length){
                    length = r - l + 1;
                    start = l;
                }

                char l_char = s.charAt(l);

                freq[l_char]++;

                if(freq[l_char] > 0){
                    count++;
                }

                l++;
            }
        }

        if(length == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start + length);

    }
}




















// class Solution {
//     public String minWindow(String s, String t) {

//         int[] freq = new int[256];

//         for(char ch : t.toCharArray()){
//             freq[ch]++;
//         }

//         int left = 0;
//         int start = 0;
//         int min_Len = Integer.MAX_VALUE;
//         int count = t.length();

//         for(int i = 0; i < s.length(); i++){

//             char ch = s.charAt(i);

//             if(freq[ch] > 0){
//                 count--;
//             }

//             freq[ch]--;

//             while(count == 0){

//                 if(i - left + 1 < min_Len){
//                     min_Len = i - left + 1;
//                     start = left;
//                 }

//                 char leftChar = s.charAt(left);

//                 freq[leftChar]++;

//                 if(freq[leftChar] > 0){
//                     count++;
//                 }

//                 left++;
//             }
//         }

//         if(min_Len == Integer.MAX_VALUE){
//             return "";
//         }

//         return s.substring(start, start + min_Len);
//     }
// }