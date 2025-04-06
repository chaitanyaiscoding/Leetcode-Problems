class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int max=1;
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dp[i]=1;
        }
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i])
                {
                    dp[i]=1+dp[j];
                    if(max<dp[i])
                    {
                        max=dp[i];
                    }
                }
            }
        }
        int prev=-1;
        for(int i=dp.length-1;i>=0;i--)
        {
            if(dp[i]==max && (prev%nums[i]==0 || prev==-1))
            {
                ans.add(nums[i]);
                max=max-1;
                prev=nums[i];
            }
        }
        return ans;

    }
}