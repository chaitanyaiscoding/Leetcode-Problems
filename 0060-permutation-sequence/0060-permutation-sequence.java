class Solution {
    public String getPermutation(int n, int k) {
        String ans="";

        ArrayList<Integer> li=new ArrayList<>();

        int fact=1;
        for(int i=1;i<n;i++)
        {
            li.add(i);
            fact=fact*i;
        }
        li.add(n);
        k=k-1;
        while(true)
        {
            ans=ans+li.get(k/fact);
            li.remove(k/fact);
            if(li.size()==0)break;
            k=k%fact;
            fact=fact/li.size();
            
        }
        return ans;
    }
}