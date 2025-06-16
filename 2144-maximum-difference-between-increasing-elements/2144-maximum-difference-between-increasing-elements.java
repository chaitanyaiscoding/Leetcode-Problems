class Solution {
    public int maximumDifference(int[] nums) {
        int ans=-1;
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            pre[i]=Math.min(pre[i-1],nums[i]);
        }
        for(int i=n-1;i>=0;i--)
        {
            if(nums[i]>pre[i])
            {
                ans=Math.max(ans,nums[i]-pre[i]);
            }
        }
        return ans;
    }
}