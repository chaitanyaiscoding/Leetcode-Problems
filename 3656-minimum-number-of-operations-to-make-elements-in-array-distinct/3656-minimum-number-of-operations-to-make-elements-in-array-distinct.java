class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr=new int[101];
        for(int i:nums)
        {
            arr[i]+=1;
        }
        int k=0;
        int ans=0;
        while(true)
        {
            int flag=0;
            for(int i=0;i<101;i++)
            {
                if(arr[i]>1){
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                ans++;
                int last=k+3;
                if(k+3>nums.length)
                    last=nums.length;
                for(int j=k;j<last;j++)
                {
                    arr[nums[j]]-=1;
                }
                k=k+3;
            }
            else
                return ans;
        }
        // return -1;
    }
}