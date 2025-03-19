class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<wordDict.size();j++)
            {
                if(i+wordDict.get(j).length()<=n && s.substring(i,i+wordDict.get(j).length()).equals(wordDict.get(j)))
                dp[i]=dp[i+wordDict.get(j).length()];
                if(dp[i]==true)break;
            }
        }
        return dp[0];
    }
}