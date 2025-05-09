class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int right=0;
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(s.charAt(i))){
                int x=map.get(s.charAt(i));
                right=Math.max(right,x+1);
                ans=Math.max(ans,i-right+1);
                map.put(s.charAt(i),i);
            }
            else
            {
                map.put(s.charAt(i),i);
                ans=Math.max(ans,i-right+1);
            }
            // System.out.println(map);
            // System.out.println(ans);

        }
        return ans;
    }
}