class Solution {
    public int maxProfit(int[] prices) {
        int mProfit = 0;
        if(prices.length == 0){
            return mProfit;
        }
        int left = 0;
        int right = 1;
        while(right < prices.length){
            int sellValue = prices[right] - prices[left];
            if(sellValue < 0){
                left = right;;
            }
            else{
                mProfit = Math.max(mProfit, sellValue);
            }
            right++;
        }
        return mProfit;
    }
}
