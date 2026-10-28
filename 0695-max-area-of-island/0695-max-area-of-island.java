class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        int maxArea=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int area=dfs(grid,i,j,m,n);

                    maxArea=Math.max(maxArea, area);
                }
            }
        }return maxArea;
        
    }

    int dfs(int grid[][], int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) return 0;

        int area=1;
        grid[i][j]=0;

        area+=dfs(grid,i-1,j,m,n);
        area+=dfs(grid,i+1,j,m,n);
        area+=dfs(grid,i,j-1,m,n);
        area+=dfs(grid,i,j+1,m,n);

        return area;
    }
}