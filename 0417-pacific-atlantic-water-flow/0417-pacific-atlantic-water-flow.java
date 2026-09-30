class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows=heights.length;
        int cols=heights[0].length;

        boolean pacific[][]=new boolean[rows][cols];
        boolean atlantic[][]=new boolean[rows][cols];

        Queue<int[]> queue=new LinkedList<>();

        for(int col=0;col<cols;col++){
            pacific[0][col]=true;
            queue.offer(new int[]{0,col});
        }
        for(int row=0;row<rows;row++){
            pacific[row][0]=true;
            queue.offer(new int[]{row,0});
        }

        bfs(heights,queue, pacific);

        for(int col=0;col<cols;col++){
            atlantic[rows-1][col]=true;
            queue.offer(new int[]{rows-1,col});
        }

        for(int row=0;row<rows;row++){
            atlantic[row][cols-1]=true;
            queue.offer(new int[]{row, cols-1});
        }

        bfs(heights,queue,atlantic);

        List<List<Integer>> result=new ArrayList<>();

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(pacific[row][col] && atlantic[row][col]) result.add(Arrays.asList(row,col));
            }
        }return result;


        
    }

    void bfs(int heights[][], Queue<int[]> queue,boolean visited[][]){

        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int current[]=queue.poll();

            int row=current[0];
            int col=current[1];

            for(int[] direction: directions){
                int newRow=row+direction[0];
                int newCol=col+direction[1];

                if(newRow<0 || newRow>=heights.length || newCol<0 || newCol>=heights[0].length || visited[newRow][newCol] || (heights[newRow][newCol]<heights[row][col])) continue;


                visited[newRow][newCol]=true;
                queue.offer(new int[]{newRow, newCol});

            }

        }
    }
}