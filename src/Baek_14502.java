import java.io.*;
import java.util.*;

public class Baek_14502 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] args = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row = args[0];
        int col = args[1];

        int[][] grid = new int[row][col];

        for(int i=0; i<row ; i++){
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        ArrayList<int[]> spaces = new ArrayList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 0){
                    spaces.add(coord(i, j));
                }
            }
        }

        //ArrayList<Integer>[] combination = new ArrayList<>[];

        for(int i=0; i<spaces.size(); i++){
            for(int j=i+1; j<spaces.size(); j++){
                for(int k=j+1; k<spaces.size(); k++){



                }
            }
        }

    }

    public void BFS(){

    }

    public int[] coord(int row, int col){
        return new int[] {row, col};
    }
}
