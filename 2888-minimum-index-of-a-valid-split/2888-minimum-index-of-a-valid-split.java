class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        map.put(i,map.getOrDefault(i,0)+1);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.size();i++)
        {
            int x=nums.get(i);
            hm.put(x,hm.getOrDefault(x,0)+1);

            int gg = hm.get(x);

            int len=i+1;

            if(gg>len/2)
            {
                int m=map.get(x);
                int right=m-gg;
                int right_len = nums.size()-i-1;
                if(right>right_len/2)
                return i;
            }
        }
        return -1;
    }
}