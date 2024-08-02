import java.io.*;
import java.util.*;

public class Baek_2468 {
    public static int[][] grid;
    public static boolean[][] visited;
    public static int size;
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int count = 0;
        size = Integer.parseInt(br.readLine());

        grid = new int[size][size];
        visited = new boolean[size][size];

        for(int i=0; i<size; i++){
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int height = 0; height <= 100 ; height++){
            Arrays.stream(visited).forEach(x -> Arrays.fill(x, false));
            count = 0;
            for(int i=0 ; i < size; i++){
                for(int j=0; j<size; j++){
                    if(isReachable(i, j, height) && !visited[i][j]){
                        BFS(i, j, height);
                        count ++;
                    }
                }
            }
            if(count == 0){
                break;
            }
            if (max < count){
                max = count;
            }
        }

        System.out.println(max);

    }

    public void BFS(int row, int col, int height){

        int[] dir_row = new int[] {0, 0, 1, -1};
        int[] dir_col = new int[] {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i=0; i<4; i++){
                int new_row = curr[0] + dir_row[i];
                int new_col = curr[1] + dir_col[i];

                if(isReachable(new_row, new_col, height)){
                    if(!visited[new_row][new_col]){
                        queue.offer(coord(new_row, new_col));
                        visited[new_row][new_col] = true;
                    }
                }
            }
        }
    }
    public boolean isReachable(int row, int col, int height){
        if(row < 0 || col < 0 || row >= size || col >=size || grid[row][col] <= height) return false;
        return true;
    }
    public int[] coord(int row, int col){
        return new int[] {row, col};

    }
    
}
