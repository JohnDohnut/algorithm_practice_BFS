import java.io.*;
import java.util.*;

public class Baek_2178 {
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        int row = Integer.parseInt(s[0]);
        int col = Integer.parseInt(s[1]);

        String[][] grid = new String[row][col];

        for(int i=0 ; i < row ; i++){
            grid[i] = br.readLine().split("");
        }

        BFS(0,0,grid);
        System.out.println(grid[grid.length-1][grid[0].length-1]);
    }

    public String BFS(int row, int col, String[][] grid){


        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        String rv = "";
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(boolean[] _row : visited){
            for(boolean _col : _row){
                _col = false;
            }
        }
        // 시작점 queue에 삽입
        queue.offer(new int[] {0,0});
        // 시작점 visited = true
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1){
                return rv;
            }

            for(int i=0; i<4 ; i++) {

                int next_row = curr[0] + dr[i];
                int next_col = curr[1] + dc[i];

                if(isReachable(next_row, next_col, grid)){
                    if(!visited[next_row][next_col]) {
                        queue.offer(new int[] {next_row, next_col});
                        visited[next_row][next_col] = true;
                        grid[next_row][next_col] = Integer.toString(Integer.parseInt(grid[curr[0]][curr[1]])+1);

                    }
                }


            }

        }
        return rv;

    }

    public boolean isReachable(int row, int col, String[][] grid){

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){return false;}

        if (grid[row][col].equals("0")){ return false;}

        return true;
    }


}
