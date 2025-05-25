class Solution {
    public int longestPalindrome(String[] words) {
        
        HashMap<String , Integer> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(String str:words)
        {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        System.out.println(map);
        int ans=0;
        int flag=0;
        int res=0;
        ArrayList<Integer> li=new ArrayList<>();
        for(Map.Entry<String,Integer> ele:map.entrySet())
        {
            String s=ele.getKey();
            String gg=String.valueOf(s.charAt(1))+String.valueOf(s.charAt(0));
            if(s.equals(gg))
            li.add(map.get(s));
            else if(map.containsKey(gg) && !set.contains(s) && !set.contains(gg))
            {
                ans=ans+4*(Math.min(map.get(gg),map.get(s)));
                set.add(s);
                set.add(gg);
                continue;
            }
        }
        Collections.sort(li,Collections.reverseOrder());
        System.out.println(li);
        // System.out.println(res);
        for(int i=0;i<li.size();i++)
        {
            if(li.get(i)%2==0)
            {
                ans=ans+li.get(i)*2;
            }
            else{
            ans=ans+(li.get(i)-1)*2;
            flag=1;
            }
        }
        if(flag==1)ans=ans+2;
        return ans;

    }
}