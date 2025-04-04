class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         if(i==0 || i== n-1 || j==0 || j==m-1)
        //         {
        //             if(grid[i][j]==1)
        //             {
        //                 grid[i][j]=0;
        //                 Queue<int[]> qu=new LinkedList<>();
        //                 qu.add(new int[]{i,j});

        //                 while(!qu.isEmpty())
        //                 {
        //                     int[] curr=qu.poll();
        //                     for(int[] dir:directions)
        //                     {
        //                         int x=curr[0];
        //                         int y=curr[1];
        //                         x=x+dir[0];
        //                         y=y+dir[1];

        //                         if(x<n && x>=0 && y<m && y>=0)
        //                         {
        //                             if(grid[x][y]==1){
        //                                 grid[x][y]=0;
        //                                 qu.add(new int[]{x,y});
        //                             }
                                    
        //                         }
        //                     }
        //                 }
                        
                        
        //             }
        //         }
        //     }
        // }
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    vis[i][j]=1; 
                    int ans=1;
                    Queue<int[]> qu=new LinkedList<>();
                    qu.add(new int[]{i,j});

                    while(!qu.isEmpty())
                    {
                        int[] curr=qu.poll();

                        for(int[] dir:directions){
                            int x=curr[0];
                            int y=curr[1];

                            x=x+dir[0];
                            y=y+dir[1];

                            if(x<n && x>=0 && y<m && y>=0 && vis[x][y]==0 && grid[x][y]==1)
                            {
                                ans++;
                                qu.add(new int[]{x,y});
                                vis[x][y]=1;
                            }
                        }
                    }
                    res=Math.max(res,ans);

                }
                
            }
        }

        return res;
    }
}