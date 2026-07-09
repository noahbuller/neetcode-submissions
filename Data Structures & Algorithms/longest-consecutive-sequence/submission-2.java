class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        int longestSequence = 1;
        for(int value : hs){
            if(hs.contains(value - 1)){
                continue;
            }
            //otherwise, start a sequence
            int currentSeq = 1;
            int placeholder = value;
            while(hs.contains(placeholder +1)){
                placeholder +=1;
                currentSeq +=1;
            }
            longestSequence = Math.max(longestSequence, currentSeq);

        }
        return longestSequence;
    }
}
