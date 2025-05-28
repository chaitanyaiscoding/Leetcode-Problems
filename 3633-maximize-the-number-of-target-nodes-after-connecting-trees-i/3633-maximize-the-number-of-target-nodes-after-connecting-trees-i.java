import java.util.*;

public class Solution {
    
    // BFS from a node in a tree up to distance k
    public static int bfs(int i, ArrayList<ArrayList<Integer>> graph, int k, int[] vis) {
        int ans = 1; // Count self
        Queue<Integer> qu = new LinkedList<>();
        qu.add(i);
        vis[i] = 1;
        int level = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();
            level++;
            if (level > k) break;

            for (int j = 0; j < size; j++) {
                int node = qu.poll();
                for (int x : graph.get(node)) {
                    if (vis[x] == 0) {
                        qu.add(x);
                        vis[x] = 1;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // Get the maximum reachable nodes in graph2 with <= k distance
    public static int bfsMax(ArrayList<ArrayList<Integer>> graph2, int k, int maxNode2) {
        int ans = 0;
        for (int i = 0; i <= maxNode2; i++) {
            int[] vis = new int[maxNode2 + 1];
            int res = bfs(i, graph2, k, vis);
            ans = Math.max(ans, res);
        }
        return ans;
    }

    // Main method as per the problem
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int maxNode1 = 0, maxNode2 = 0;
        for (int[] edge : edges1)
            maxNode1 = Math.max(maxNode1, Math.max(edge[0], edge[1]));
        if (k == 0) {
        int[] answer = new int[maxNode1 + 1];
        Arrays.fill(answer, 1); // Each node is only target to itself
        return answer;
    }
        
        for (int[] edge : edges2)
            maxNode2 = Math.max(maxNode2, Math.max(edge[0], edge[1]));

        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i <= maxNode1; i++) graph1.add(new ArrayList<>());
        for (int i = 0; i <= maxNode2; i++) graph2.add(new ArrayList<>());

        for (int[] edge : edges1) {
            graph1.get(edge[0]).add(edge[1]);
            graph1.get(edge[1]).add(edge[0]);
        }
        for (int[] edge : edges2) {
            graph2.get(edge[0]).add(edge[1]);
            graph2.get(edge[1]).add(edge[0]);
        }

        int Mg2 = bfsMax(graph2, k - 1, maxNode2);
        int[] ans = new int[maxNode1 + 1];

        for (int i = 0; i <= maxNode1; i++) {
            int[] vis = new int[maxNode1 + 1];
            int res = bfs(i, graph1, k, vis);
            ans[i] = res + Mg2;
        }

        return ans;
    }

    // Optional: Main method to run and test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] edges1 = {{0, 1}, {1, 2}};
        int[][] edges2 = {{0, 1}};
        int k = 2;

        int[] result = sol.maxTargetNodes(edges1, edges2, k);
        System.out.println(Arrays.toString(result)); // Example output
    }
}
