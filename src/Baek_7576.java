import java.util.*;
import java.io.*;
// Put every starting vertex into queue at the beginning of BFS
public class Baek_7576 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int row = size[1];
        int col = size[0];
        int[][] grid = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row;i++){
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        }

        BFS(grid);
        int rv = 0;
        boolean isRiped = true;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if (grid[i][j] > rv){
                    rv = grid[i][j];
                }
                if (grid[i][j] == 0){
                    isRiped = false;
                }
            }
        }
        if(isRiped){
            System.out.println(rv-1);
        }
        else{
            System.out.println(-1);
        }


    }


    public int BFS(int[][] grid){

        int[] dir_row = new int[] {0,0,1,-1};
        int[] dir_col = new int[] {1,-1,0,0};
        int days = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length ; i++){
            for(int j=0; j<grid[0].length ; j++){
                if(grid[i][j] == 1){
                    queue.offer(coord(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int i=0; i<4; i++){
                int new_row = curr[0] + dir_row[i];
                int new_col = curr[1] + dir_col[i];

                if(isReachable(new_row, new_col, grid)){
                    if(grid[new_row][new_col] == 0){
                        queue.offer(coord(new_row, new_col));
                        grid[new_row][new_col] = grid[curr[0]][curr[1]] + 1;

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
