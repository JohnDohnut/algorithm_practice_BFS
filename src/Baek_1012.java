import java.io.*;
import java.util.*;

public class Baek_1012 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        for(int i=0; i<tests ; i++){
            //get inputs
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] grid = new int[inputs[1]][inputs[0]];
            boolean[][] visited = new boolean[inputs[1]][inputs[0]];
            int worms = 0;
            //init
            for(int p = 0; p<grid.length; p++){
                for(int q=0; q<grid[0].length ; q ++){
                    grid[p][q] = 0;
                }
            }
            //fill
            for(int j=0;j<inputs[2];j++){
                int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                grid[position[1]][position[0]] = 1;
            }
            //BFS
            for(int row = 0 ; row < grid.length ; row ++){
                for(int col = 0 ; col < grid[0].length ; col ++){
                    if(isReachable(row, col, grid)){
                        if(!visited[row][col]){
                            BFS(row, col, grid, visited);
                            worms ++;
                        }
                    }
                }
            }
            System.out.println(worms);

        }

    }

    public void BFS(int row, int col, int[][] grid, boolean[][] visited){

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(coord(row, col));
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int i=0; i<4; i++){
                int new_row = curr[0] + dr[i];
                int new_col = curr[1] + dc[i];

                if(isReachable(new_row, new_col, grid)){
                    if(!visited[new_row][new_col]){
                        queue.offer(coord(new_row, new_col));
                        visited[new_row][new_col] = true;
                    }
                }



            }
        }
    }

    public boolean isReachable(int row, int col, int[][] grid){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return false;
        }
        return true;

    }

    public int[] coord(int row, int col){
        return new int[] {row, col};
    }

}
