class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int n=s.length();
        int ans=0;
        while(right<n)
        {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()==3)
            {
                ans=ans+n-right;
                char chr = s.charAt(left);
                map.put(chr, map.get(chr) - 1);
                if (map.get(chr) == 0) {
                    map.remove(chr);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}