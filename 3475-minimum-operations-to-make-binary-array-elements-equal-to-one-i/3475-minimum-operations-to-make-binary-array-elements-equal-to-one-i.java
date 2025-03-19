class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n-2;i++)
        {
            if(nums[i]==0)
            {
                nums[i]=1;
                if(nums[i+1]==0)
                    nums[i+1]=1;
                else
                    nums[i+1]=0;
                if(nums[i+2]==0)
                    nums[i+2]=1;
                else
                    nums[i+2]=0;
                ans++;
            }
        }
        if(nums[n-1]==0 || nums[n-2]==0)
            return -1;
        return ans;
        
    }
}