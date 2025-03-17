class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> ele:map.entrySet())
        {
            if(ele.getValue()%2!=0)return false;
        }
        return true;
    }
}