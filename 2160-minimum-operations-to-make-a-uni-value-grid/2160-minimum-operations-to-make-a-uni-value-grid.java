class Solution {
    public int minOperations(int[][] grid, int x) {
        
        int flag=0;
        int sum=0;
        int n=grid.length;
        int m=grid[0].length;
        int[] arr=new int[n*m];
        int gg=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]%x != grid[0][0]%x)
                {
                    flag=1;
                }
                arr[gg++]=grid[i][j];
                sum+=grid[i][j];
            }
        }
        if(flag==1)
        return -1;
        Arrays.sort(arr);
        int pre=0;
        // int ans=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n*m;i++)
        {
            int cost_left=arr[i]*i-pre;
            int cost_right=sum-pre-(arr[i]*((n*m)-i));
            int ans=(cost_left+cost_right)/x;
            res=Math.min(res,ans);
            pre+=arr[i];
        }
        return res;
    }
}