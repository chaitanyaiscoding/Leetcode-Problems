class Solution {
    public static boolean solve(int[] nums,int idx,int k,Boolean[][] dp)
    {
        if(k==0)return true;

        if(idx>=nums.length)return false;
        if(dp[idx][k]!=null)
        return dp[idx][k];
        boolean take=false;

        if(nums[idx]<=k)
        take=solve(nums,idx+1,k-nums[idx],dp);

        boolean nt = solve(nums,idx+1,k,dp);
        dp[idx][k]=take||nt;
        return dp[idx][k];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)sum+=i;
        if(sum%2!=0)return false;
        int half=sum/2;
        Boolean[][] dp=new Boolean[nums.length+1][half+1];
        //we need to check whether we have a subset with sum half

        if(solve(nums,0,half,dp))
        return true;
        return false;
    }
}