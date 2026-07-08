class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int [] solution = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length -1] = nums[nums.length -1];
        for(int i =1; i< nums.length; i++){
            prefix[i] = nums[i] * prefix[i-1];
        }
        for(int i = nums.length -2; i >= 0; i--){
            postfix[i] = nums[i] * postfix[i+1];
        }
        solution[0] = postfix[1];
        solution[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < solution.length - 1; i++){
            solution[i] = prefix[i-1] * postfix[i+1];
        }
        return solution;
    }
}