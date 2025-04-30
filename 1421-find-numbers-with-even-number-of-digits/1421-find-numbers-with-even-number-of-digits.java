class Solution {
    public int findNumbers(int[] nums) {
        int ans=0;
        for(int x:nums)
        {
            int c=0;
            while(x>0)
            {
                x=x/10;
                c++;
            }
            if(c%2==0)ans++;
        }
        return ans;
    }
}