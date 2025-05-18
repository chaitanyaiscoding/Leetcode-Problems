import java.util.*;

class Solution {
    public static int bs(int low, int high, int[][] arr, int et) {
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid][0] >= et) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int solve(int[][] arr, int i, Integer[] dp) {
        if (i == arr.length) return 0;

        if (dp[i] != null) return dp[i];

        // Pick the current job
        int j = bs(i + 1, arr.length - 1, arr, arr[i][1]);
        int con = arr[i][2] + solve(arr, j, dp);

        // Skip the current job
        int not_con = solve(arr, i + 1, dp);

        return dp[i] = Math.max(con, not_con);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        Integer[] dp = new Integer[n];
        return solve(arr, 0, dp);
    }
}
