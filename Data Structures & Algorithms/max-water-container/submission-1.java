class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;
        while(right > left){
            int currentWater = Math.min(heights[left],heights[right]) * (right -left);
            maxWater = Math.max(maxWater, currentWater);
            if(heights[right] > heights[left]){
                left++;
            }
            else{
                right --;
            }
        }
        return maxWater;
    }
}
