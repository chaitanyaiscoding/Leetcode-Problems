class Solution {
    public int minOperations(String s) {
        String ans="";
      String ans1="";
      int i=0;
      int count=0;
      int count1=0;
      while(i<s.length())
      {
          ans=ans+'1';
          ans=ans+'0';
          i=i+2;
      }
      int j=0;
      while(j<s.length())
      {
          ans1=ans1+'0';
          ans1=ans1+'1';
          j=j+2;
      }
      for(int k=0;k<s.length();k++)
      {
        if(s.charAt(k)!=ans.charAt(k))
        count++;
        if(s.charAt(k)!=ans1.charAt(k))
        count1++;
      }
      return (Math.min(count,count1));
    }
}