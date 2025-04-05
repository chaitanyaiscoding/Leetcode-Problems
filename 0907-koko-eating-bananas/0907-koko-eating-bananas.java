class Solution {
    public static boolean solve(int[] piles, int mid, int h) {
        long hours_req = 0;
        for (int i : piles) {
            hours_req += (i + mid - 1) / mid;
        }
        return hours_req <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i:piles)high=Math.max(high,i);
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(solve(piles,mid,h))
            {
                high=mid-1;
                ans=mid;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}