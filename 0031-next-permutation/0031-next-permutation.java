class Solution {
    public static void reverse(int idx,int[] nums)
    {
        int left=idx+1;
        int right=nums.length-1;
        while(left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        int max=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<max)
            {
                idx=i;
                break;
            }
            else
            max=Math.max(max,nums[i]);
        }
        if(idx==-1){
        reverse(idx,nums);
        return ;
        }

        for(int i=n-1;i>idx;i--)
        {
            if(nums[i]>nums[idx])
            {
                int temp=nums[idx];
                nums[idx]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        
        reverse(idx,nums);
    }
}