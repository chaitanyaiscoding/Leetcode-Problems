class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    int f=nums[i];
                    int s=nums[j];
                    int t=nums[k];

                    long res=(long)(f-s)*(long)t;
                    // res=Math.max(0,res);

                    ans=Math.max(ans,res);
                }
            }

        }
        return ans;
    }
}