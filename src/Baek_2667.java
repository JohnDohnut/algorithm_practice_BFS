import java.io.*;
import java.util.*;
public class Baek_2667 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> result = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());
        int[][] grid = new int[size][size];
        for(int i=0 ; i < size ; i ++ ){
            grid[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(x -> Integer.parseInt(x))
                    .toArray();
        }

        boolean[][] visited = new boolean[size][size];
        Arrays.setAll(visited , i->{
            boolean[] row = new boolean[size];
            Arrays.fill(row, false);
            return row;
        });
        for(int row=0; row<size; row++){
            for (int col=0; col<size; col++){
                if(grid[row][col] == 1 && !visited[row][col]) {
                    result.add(BFS(grid, visited, row, col));
                }
            }
        }
        result.sort((a,b) -> a-b);
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

    public int BFS(int[][] grid, boolean[][] visited, int row, int col){
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        int count = 1;
        int[] curr = coord(row, col);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(curr);
        visited[row][col] = true;

        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int direction = 0; direction < 4 ; direction ++){
                int next_row = curr[0] + dr[direction];
                int next_col = curr[1] + dc[direction];
                if(isReachable(next_row, next_col, grid)){
                    if(!visited[next_row][next_col]){
                        queue.offer(coord(next_row, next_col));
                        visited[next_row][next_col]=true;
                        count++;
                    }
                }

            }
        }
        return count;
    }

    public int[] coord(int row, int col){
        return new int[]{row, col};
    }

    public boolean isReachable(int row, int col, int[][] grid){
        if( row < 0
                || col < 0
                || row >= grid.length
                || col >= grid[0].length
                || grid[row][col] == 0){

            return false;
        }
        return true;
    }
}
