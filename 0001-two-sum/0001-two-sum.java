class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int ele=nums[i];
            int req=target-nums[i];
            if(map.containsKey(req))
            {
                return new int[]{map.get(req),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}