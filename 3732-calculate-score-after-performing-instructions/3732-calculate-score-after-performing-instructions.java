class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        long score=0;
        int n=instructions.length;
        while(i<n && !set.contains(i))
        {
            String x=instructions[i];
            set.add(i);
            if(x.equals("add"))
            {
                score=score+values[i];
                i++;
            }
            else if(x.equals("jump"))
            {
                i=i+values[i];
                if(i>=n || i<0)break;
                if(set.contains(i))
                break;
            }
            // System.out.println(score);
        }
        return score;
    }
}