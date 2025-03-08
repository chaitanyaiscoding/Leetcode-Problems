class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] soe=new boolean[10000000];
        Arrays.fill(soe,true);
        soe[0]=false;
        soe[1]=false;
        for(int i=2;i*i<soe.length;i++)
        {
            if(soe[i]==true)
            {
                for(int j=i*i;j<soe.length;j=j+i)
                soe[j]=false;
            }
        }
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(soe[i]==true)
            li.add(i);
            // System.out.println(i+" "+soe[i]);
        }
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<li.size();i++)
        {
            if(li.get(i)-li.get(i-1)<min)
            {
                min=li.get(i)-li.get(i-1);
                ans[0]=li.get(i-1);
                ans[1]=li.get(i);
            }
        }
        
        return ans;
        
    }
}