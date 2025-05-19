class Solution {
    public String triangleType(int[] nums) {
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        if(a+b<=c || b+c<=a || c+a<=b)return "none";
        HashSet<Integer> set=new HashSet<>();
        set.add(nums[0]);
        set.add(nums[1]);
        set.add(nums[2]);
        if(set.size()==1)
        return "equilateral";
        else if(set.size()==2)
        return "isosceles";
        else
        return "scalene";

        // return ""
    }
}