class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int result =0;
        int maxValue = 0;
        int l = 0;
        for (int r = 0; r< s.length(); r++){
            int asciivalue = s.charAt(r) - 65;
            freq[asciivalue]++;
            maxValue = Math.max(maxValue, freq[asciivalue]);
            while((r-l+1) - maxValue > k){
                freq[s.charAt(l) - 65] --;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
;