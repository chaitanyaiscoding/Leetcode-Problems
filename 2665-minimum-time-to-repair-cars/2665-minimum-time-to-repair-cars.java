import java.util.Arrays;

class Solution {
    public static long solve(int[] ranks, long time) {
        long count = 0;
        for (int rank : ranks) {
            count += (long) Math.sqrt(time / (double) rank);
        }
        return count;
    }

    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long min = 1;
        long max = (long) ranks[0] * cars * cars;
        long ans = max;

        while (min <= max) {
            long mid = min + (max - min) / 2;
            long repaired = solve(ranks, mid);
            if (repaired >= cars) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
}
