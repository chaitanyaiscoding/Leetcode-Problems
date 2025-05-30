class Solution {
    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[] visited = new boolean[n];
        
        int d = 0;
        while (start != -1 && !visited[start]) {
            dist[start] = d++;
            visited[start] = true;
            start = edges[start];
        }
        
        return dist;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = getDistances(edges, node1);
        int[] dist2 = getDistances(edges, node2);

        int minDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }
}
