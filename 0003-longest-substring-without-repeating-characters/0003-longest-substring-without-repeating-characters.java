class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),i);
                ans=Math.max(ans,i-left+1);
            }
            else
            {
                left=Math.max(left,map.get(s.charAt(i))+1);
                ans=Math.max(ans,i-left+1);
                map.put(s.charAt(i),i);
            }
        }
        return ans;
    }
}