class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for(String str:strs)
        {
            char[] s=str.toCharArray();
            Arrays.sort(s);
            String gg=new String(s);
            // System.out.println(Arrays.toString(s));
            if(map.containsKey(gg))
            {
                // System.out.println("yes");
                ArrayList<String> li=map.get(gg);
                li.add(str);
                System.out.println(li);
                map.put(gg,li);
            }
            else
            {
                ArrayList<String> li=new ArrayList<>();
                li.add(str);
                map.put(gg,li);
            }

        }
        // System.out.println(map);
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,ArrayList<String>> ele:map.entrySet()){
            ans.add(ele.getValue());
        }

        return ans;
    }
}