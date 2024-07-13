import java.util.*;
import java.io.*;

public class Baek_7576 {
    public void solution() throws IOException{


    }


    public int BFS(int row, int col, int[][] grid, boolean [][] visited){

        int[] dir_row = new int[] {0,0,1,-1};
        int[] dir_col = new int[] {1,-1,0,0};


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(coord(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;

            for(int i=0; i<4; i++){
                int new_row = curr[0] + dir_row[i];
                int new_col = curr[1] + dir_col[i];

                if(isReachable(new_row, new_col, grid)){
                    if(!visited[new_row][new_col]){
                        visited[new_row][new_col] = true;
                        grid[new_row][new_col] = grid[curr[0]][curr[1]] + 1;
                        queue.offer(coord(new_row, new_col));
                    }
                }
            }

        }

        return 0;
    }

    public int[] coord(int row, int col){
        return new int[]{row, col};
    }
    public boolean isReachable(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1){
            return false;
        }
        return true;
    }

}
