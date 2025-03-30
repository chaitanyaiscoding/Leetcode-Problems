class Solution {
    public List<Integer> partitionLabels(String s) {
        LinkedHashMap<Character,int[]> map=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            
            if(map.containsKey(s.charAt(i)))
            {
                int[] gg=map.get(s.charAt(i));
                gg[1]=i;
                map.put(s.charAt(i),gg);
            }
            else
            {
                int[] gg=new int[2];
                gg[0]=i;
                gg[1]=i;
                map.put(s.charAt(i),gg);
            }
            
        }
        int len=0;
        int left=0;
        int right=0;
        for(Map.Entry<Character,int[]> ele:map.entrySet())
        {
            int[] x=ele.getValue();
            left=x[0];
            right=x[1];
            break;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Character,int[]> ele:map.entrySet())
        {
            int[] x=ele.getValue();
            if((x[0]>=left && x[0]<=right)&&(x[1]>=left && x[1]<=right))
            continue;
            if(x[0]>right)
            {
                ans.add(right-left+1);
                left=x[0];
                right=x[1];
            }
            else {
                right=Math.max(right,x[1]);
            }
        }
        ans.add(right-left+1);
        return ans;
    }
}