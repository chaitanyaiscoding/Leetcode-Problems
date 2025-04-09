class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0]<k)return -1;
        int ans=0;
        int n=nums.length;
        int max=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]==max)
                continue;
            else
            {
                max=nums[i];
                ans++;
            }
        }
        if(max!=k)
            ans++;
        return ans;
    }
}