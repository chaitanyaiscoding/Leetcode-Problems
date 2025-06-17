class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char x : tasks)
            arr[x - 'A'] += 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            if (i != 0) pq.add(i);
        }

        Queue<int[]> qu = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !qu.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int x = pq.poll();
                x = x - 1;
                if (x > 0) {
                    qu.add(new int[]{x, time + n});
                }
            }

            if (!qu.isEmpty() && qu.peek()[1] == time) {
                pq.add(qu.poll()[0]);
            }
        }

        return time;
    }
}
