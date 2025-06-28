class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] arr=new int[k];
        Arrays.fill(arr,Integer.MIN_VALUE);

        for(int x:nums)
        {
            if(x>=arr[0])
            {
                arr[0]=x;
                Arrays.sort(arr);
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:arr)
        map.put(x,map.getOrDefault(x,0)+1);

        int[] ans=new int[k];
        int p=0;

        for(int ele:nums)
        {
            if(map.containsKey(ele))
            {
                ans[p]=ele;
                p++;
                map.put(ele,map.get(ele)-1);
                if(map.get(ele)==0)
                map.remove(ele);
            }
            
        }
        return ans;
    }
}