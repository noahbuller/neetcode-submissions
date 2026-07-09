class Solution {
    public int lengthOfLongestSubstring(String s) {
            HashSet<Character> hs = new HashSet<>();
        int maxSubstringLength = 0;
        if(s.length() == 0){
            return maxSubstringLength;
        }
        int left = 0;
            for(int right = 0; right< s.length(); right++){
                while(hs.contains(s.charAt(right))){
                    hs.remove(s.charAt(left));
                    left++;
                }
                hs.add(s.charAt(right));
                maxSubstringLength = Math.max(maxSubstringLength, (right - left) +1);
            }
        return maxSubstringLength;
    }
}
