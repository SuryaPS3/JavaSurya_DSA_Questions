import java.util.*;
public class Leetcode_994_Graph {
    public static void main(String[] args) {
        Solution994 sol994 = new Solution994();

        // Example grid
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = sol994.orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + result);
    }
}

class Solution994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int fresh = 0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0}); //(i,j,time)
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr= q.poll();
            int r= curr[0];
            int c = curr[1];
            int time = curr[2];

            for(int[] d:directions){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    fresh--;
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc,time+1});
                    minutes=Math.max(minutes, time+1);
                }
            }
        }

        return (fresh==0)?minutes:-1;
    }
}




