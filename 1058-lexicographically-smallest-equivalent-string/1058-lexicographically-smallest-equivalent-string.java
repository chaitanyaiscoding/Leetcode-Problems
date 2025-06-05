class Solution {
    static int[] parent = new int[26];
    public static char findultimateparent(char x) {
        int idx = x - 'a';
        if (parent[idx] != idx) {
            parent[idx] = findultimateparent((char)(parent[idx] + 'a')) - 'a';  
        }
        return (char)(parent[idx] + 'a');
    }
    public static void union(char x1, char x2) {
        char p1 = findultimateparent(x1);
        char p2 = findultimateparent(x2);

        if (p1 == p2) return;

        if (p1 < p2) {
            parent[p2 - 'a'] = p1 - 'a';
        } else {
            parent[p1 - 'a'] = p2 - 'a';
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i), s2.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char x = findultimateparent(baseStr.charAt(i));
            ans.append(x);
        }

        return ans.toString();
    }
}