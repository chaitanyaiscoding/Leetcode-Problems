class Solution {
    public String sortVowels(String s) {
        char[] arr=s.toCharArray();
        char[] ans=new char[s.length()];
        Arrays.fill(ans,'.');
        HashSet<Character> set=new HashSet<>();
        ArrayList<Character> li=new ArrayList<>();
        set.add('A');
        set.add('a');
        set.add('E');
        set.add('e');
        set.add('I');
        set.add('i');
        set.add('O');
        set.add('o');
        set.add('U');
        set.add('u');
        for(int i=0;i<s.length();i++)
        {
            if(!set.contains(arr[i]))
            {
                ans[i]=arr[i];
            }
            else
            {
                li.add(arr[i]);
            }
        }
        Collections.sort(li);
        int gg=0;
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]=='.')
            {
                ans[i]=li.get(gg);
                gg++;
            }
        }
        StringBuilder sb=new StringBuilder("");
        for(char x:ans)
        sb.append(x);
        return sb.toString();

    }
}