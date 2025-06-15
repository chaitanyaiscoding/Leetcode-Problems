class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> front = new HashMap<>();
        HashMap<Integer, Integer> back = new HashMap<>();
        final int MOD = 1000000007;

        for (int i = 1; i < n; i++) {
            back.put(nums[i], back.getOrDefault(nums[i], 0) + 1);
        }

        front.put(nums[0], 1);
        long ans = 0;

        for (int i = 1; i < n - 1; i++) {
            back.put(nums[i], back.get(nums[i]) - 1);
            int x = nums[i] * 2;

            if (front.containsKey(x) && back.containsKey(x)) {
                long left = front.get(x);
                long right = back.get(x);
                ans = (ans + (left * right) % MOD) % MOD;
            }

            front.put(nums[i], front.getOrDefault(nums[i], 0) + 1);
        }

        return (int) ans;
    }
}
