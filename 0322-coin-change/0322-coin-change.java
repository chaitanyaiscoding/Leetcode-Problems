class Solution {
    public static int solve(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0) return 0;
        if (idx >= coins.length) return Integer.MAX_VALUE;

        if (dp[idx][amount] != -1) return dp[idx][amount];

        int take = Integer.MAX_VALUE;

        if (amount >= coins[idx]) {
            int res = solve(coins, amount - coins[idx], idx, dp);
            if (res != Integer.MAX_VALUE)
                take = 1 + res;
        }

        int not_take = solve(coins, amount, idx + 1, dp);

        dp[idx][amount] = Math.min(take, not_take);
        return dp[idx][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = solve(coins, amount, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
