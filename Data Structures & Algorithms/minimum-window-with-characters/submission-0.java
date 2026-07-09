class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return t;
        }
        HashMap<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = freqT.size();
        int l = 0;
        int r = 0;
        int answerLength = 1001;
        int subL = 0;
        int subR = 0;
        while (r < s.length()) {
            char temp = s.charAt(r);
            if (freqT.containsKey(temp)) {
                freqT.put(temp, freqT.get(temp) - 1);
                if (freqT.get(temp) == 0) {
                    have += 1;
                }
                while (l <= r && have == need) {
                    int currLen = r - l + 1;
                    if (currLen < answerLength) {
                        answerLength = currLen;
                        subL = l;
                        subR = r;
                    }
                    char ch = s.charAt(l);
                    if (freqT.containsKey(ch)) {
                        freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
                        if(freqT.get(ch) > 0){
                            have --;
                        }
                    }
                    l++;
                }
            }
            r += 1;
        }
        return answerLength == 1001 ? "" : s.substring(subL, subR + 1);
    }
}
