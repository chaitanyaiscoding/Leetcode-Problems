class Solution {
    public static int solve(int n,int[] dp)
    {
        if(dp[n]!=0)return dp[n];

        if(n==0)return dp[0];
        if(n==1)return dp[1];
        if(n==2)return 2;
        dp[n]=solve(n-1,dp)+solve(n-2,dp);
        return dp[n];

    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        return solve(n,dp);
    }

}