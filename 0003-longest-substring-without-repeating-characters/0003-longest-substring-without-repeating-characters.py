class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        left=0
        ans=0
        map={}
        for i in range(n):
            if s[i] not in map:
                map[s[i]]=i
                ans=max(ans,i-left+1)
            else:
                left=max(left,map[s[i]]+1)
                ans=max(ans,i-left+1)
                map[s[i]]=i
        return ans