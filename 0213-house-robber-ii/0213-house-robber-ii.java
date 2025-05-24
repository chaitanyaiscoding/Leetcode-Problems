class Solution {
    public static int solve(int[] nums,int i,int x,int[] dp)
    {
        if(i>x)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+solve(nums,i+2,x,dp);
        int not_take=solve(nums,i+1,x,dp);

        dp[i]=Math.max(take,not_take);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(solve(nums,0,n-2,dp1),solve(nums,1,n-1,dp2));
    }
}