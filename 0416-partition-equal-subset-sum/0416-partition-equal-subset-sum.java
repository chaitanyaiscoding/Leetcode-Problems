class Solution {
    public static boolean solve(int[] nums,int idx,int k,Boolean[][] dp)
    {
        if(k==0)return true;

        if(idx>=nums.length){
            return false;
        }

        if(dp[idx][k]!=null)return dp[idx][k];
        boolean take=false;

        if(k>=nums[idx])
        {
            take=solve(nums,idx+1,k-nums[idx],dp);
        }
        boolean not_take=solve(nums,idx+1,k,dp);

        dp[idx][k]=take||not_take;

        return dp[idx][k];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)sum=sum+x;
        
        if(sum%2!=0)return false;
        int k=sum/2;
        Boolean[][] dp=new Boolean[nums.length+1][k+1];
        if(solve(nums,0,sum/2,dp))return true;
        return false;
    }
}