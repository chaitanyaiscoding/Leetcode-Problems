class Solution {
    public long countGood(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int idx=-1;
        int j=0;
        int count=0;
        long ans=0;
        long pairs=0;
        for(int i=0;i<n;i++)
        {
            // if(map.containsKey(i))count++;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            pairs+=map.get(nums[i])-1;
            if(pairs>=k)
            {
                // ans=ans+n-idx;
                while(j<=i && pairs>=k)
                {
                    ans=ans+(n-i);
                    map.put(nums[j],map.get(nums[j])-1);
                    pairs=pairs-map.get(nums[j]);
                    // if(map.get(nums[j])==0)map.remove(nums[j]);
                    j++;
                }
            }
        }

        return ans;
         
    }
}