class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int[][] directions={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    Queue<int[]> pq=new LinkedList<>();
                    pq.add(new int[]{i,j});
                    vis[i][j]=-1;
                    ans++;
                    while(!pq.isEmpty())
                    {
                        int[] cur=pq.poll();
                        int x=cur[0];
                        int y=cur[1];
                        for(int[] dir:directions){
                            if(x+dir[0]>=0 && y+dir[1]>=0 && x+dir[0]<m && y+dir[1]<n){
                                if(grid[x+dir[0]][y+dir[1]]=='1' && vis[x+dir[0]][y+dir[1]]==0)
                                {
                                    vis[x+dir[0]][y+dir[1]]=-1;
                                    pq.add(new int[]{x+dir[0],y+dir[1]});
                                }
                            }
                            
                        }
                        
                    }
                }
            }
        }
        return ans;
    }
}