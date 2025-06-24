class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]==key)
            {
                if(!set.contains(i))
                {
                    ans.add(i);
                    set.add(i);
                }
                for(int j=i-k;j<=i+k;j++)
                {
                    if(j>=0 && j<n && !set.contains(j)){
                    ans.add(j);
                    set.add(j);
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}