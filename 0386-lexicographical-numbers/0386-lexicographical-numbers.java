class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] arr=new String[n];
        for(int i=1;i<=n;i++) arr[i-1]=String.valueOf(i);
        Arrays.sort(arr);
        ArrayList<Integer> ans=new ArrayList<>();
        for(String i:arr) ans.add(Integer.valueOf(i));
        return ans;
    }
}