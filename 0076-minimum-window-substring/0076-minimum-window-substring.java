class Solution {
    public static boolean check(int[] main,int map[])
    {
        for(int i=0;i<130;i++)
        {
            if(map[i]<main[i])return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int[] main=new int[130];
        int[] map=new int[130];
        int flag=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++)
        {
            main[t.charAt(i)]+=1;
        }
        int i=0;
        int left=0;
        int l=0;
        int r=0;
        while(i<s.length())
        {
            map[s.charAt(i)]+=1;
            while(check(main,map))
            {
                if(i-left+1<ans)
                {
                    ans=i-left+1;
                    l=left;
                    r=i;
                }
                map[s.charAt(left)]-=1;
                left++;
            }
            i++;
        }
        // System.out.println(l+ "+r);
        if(ans==Integer.MAX_VALUE)return "";
        return s.substring(l,r+1);
    }
}