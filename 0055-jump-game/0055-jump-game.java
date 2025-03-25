class Solution {
    public static boolean solve(int[] nums,int idx,Boolean[] dp)
    {
        if(idx==nums.length-1)return true;
        if(nums[idx]==0)return false;
        if(dp[idx]!=null)return dp[idx];
        
        for(int i=idx+1;i<Math.min(nums.length,idx+1+nums[idx]);i++)
        {
            if(solve(nums,i,dp))return dp[i]=true;
        }

        dp[idx]=false;

        return dp[idx];
    }
    public boolean canJump(int[] nums) {
        // if(nums.length==1)return true;
        Boolean[] dp=new Boolean[nums.length+1];
        // Arrays.fill(dp,-1);
        return solve(nums,0,dp);

    }
}