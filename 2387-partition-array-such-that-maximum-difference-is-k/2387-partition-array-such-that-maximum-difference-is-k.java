class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int res=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]-res<=k) continue;
            else {
                ans++;
                res=nums[i];
            }
        }
        return ans+1;
    }
}