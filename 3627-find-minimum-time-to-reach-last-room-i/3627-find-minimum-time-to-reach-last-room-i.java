class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int[][] directions={{-1,0},{0,1},{0,-1},{1,0}};
        int[][] vis=new int[n][m];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.add(new int[]{0,0,0});
        vis[0][0]=1;

        while(true)
        {
            int[] curr=pq.poll();
            int time=curr[0];
            int x=curr[1];
            int y=curr[2];
            if(x==n-1 && y==m-1)return time;

            for(int[] dir:directions)
            {
                int nx=x+dir[0];
                int ny=y+dir[1];

                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==0)
                {
                    vis[nx][ny]=1;
                    if(moveTime[nx][ny]>time)
                    pq.add(new int[]{moveTime[nx][ny]+1,nx,ny});
                    else
                    pq.add(new int[]{time+1,nx,ny});
                }
            }
        }

        // return -1;
    }
}