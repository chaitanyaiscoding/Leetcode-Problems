class Solution {
    public void sortColors(int[] nums) {
        int[] arr=new int[3];
        for(int i:nums)arr[i]+=1;
        int k=0;
        for(int i=0;i<3;i++)
        {
            int x=arr[i];
            for(int j=0;j<x;j++)
            nums[k++]=i;
        }
        // return nums;
    }
}