class Solution {
    public static long solve(int[][] questions,int idx,long[] dp)
    {
        if(idx>=questions.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        long take=questions[idx][0]+solve(questions,idx+questions[idx][1]+1,dp);
        long not_take=solve(questions,idx+1,dp);

        dp[idx]=Math.max(take,not_take);

        return dp[idx];



    }
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        for(int i=0;i<dp.length;i++)
        dp[i]=(long)-1;
        return solve(questions,0,dp);
    }
}