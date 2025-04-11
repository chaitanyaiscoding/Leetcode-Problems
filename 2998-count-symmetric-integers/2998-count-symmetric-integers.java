class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++)
        {
            String s=String.valueOf(i);
            if(s.length()%2!=0)
            continue;
            int half=s.length()/2;
            int sum=0;
            for(int j=0;j<half;j++)
            {
                sum+=Integer.parseInt(String.valueOf(s.charAt(j)));
                sum=sum-Integer.parseInt(String.valueOf(s.charAt(half+j)));
            }
            if(sum==0)ans++;
        }
        return ans;
    }
}