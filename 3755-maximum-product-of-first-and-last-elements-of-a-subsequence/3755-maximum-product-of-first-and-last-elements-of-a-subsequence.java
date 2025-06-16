class Solution {
    public long maximumProduct(int[] nums, int m) {
        
        long ma = nums[0], mi = nums[0], res = 1L * nums[0] * nums[m - 1];
        for (int i = m - 1; i < nums.length; ++i) {
            ma = Math.max(ma, nums[i - m + 1]);
            mi = Math.min(mi, nums[i - m + 1]);
            res = Math.max(res, Math.max(mi * nums[i], ma * nums[i]));
        }
        return res;
    }
}