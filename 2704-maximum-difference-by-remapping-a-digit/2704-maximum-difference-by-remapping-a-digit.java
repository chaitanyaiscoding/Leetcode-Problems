class Solution {
    public int minMaxDifference(int num) {
        String s=String.valueOf(num);
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=9;i++)
        {
            char[] nine=s.toCharArray();
            char[] zero=s.toCharArray();
            for(int j=0;j<s.length();j++)
            {
                if(nine[j]-'0'==i)
                nine[j]='9';
                if(zero[j]-'0'==i)
                zero[j]='0';
            }
            String temp1=String.valueOf(nine);
            String temp2=String.valueOf(zero);
            int num1=Integer.parseInt(temp1);
            int num2=Integer.parseInt(temp2);
            max=Math.max(max,num1);
            min=Math.min(min,num2);
            // System.out.println(max+" "+min);
        }
        // System.out.println(max+" "+min);
        return max-min;

    }
}