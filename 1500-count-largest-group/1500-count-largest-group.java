class Solution {
    public static int solve(int x)
    {
        int ans=0;
        while(x>0)
        {
            ans=ans+(x%10);
            x=x/10;
        }
        return ans;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            int sum=solve(i);
            // System.out.println(sum);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        // System.out.println(map);
        int res=0;
        int max=0;
        for(Map.Entry<Integer,Integer> ele:map.entrySet())
        {
            if(max<ele.getValue())
            {
                res=1;
                max=ele.getValue();
            }
            else if(max==ele.getValue())
            {
                res++;
            }
        }
        return res;
    }
}