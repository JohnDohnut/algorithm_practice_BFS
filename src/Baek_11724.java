import java.util.*;
import java.io.*;

public class Baek_11724 {
    public void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] args = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int verticies = args[0];
        int edges = args[1];

        ArrayList<Integer>[] adj = new ArrayList[verticies+1];
        boolean[] visited = new boolean[verticies+1];
        for(int i=0; i< adj.length; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edges ; i++){
            args = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[args[0]].add(args[1]);
            adj[args[1]].add(args[0]);
        }
        int count = 0;
        for(int vertex=1; vertex<verticies+1; vertex++){
            if(!visited[vertex]){
                count ++;
                BFS(vertex, adj, visited);
            }
        }
        System.out.println(count);

    }
    public void BFS(int vertex, ArrayList[] adj, boolean[] visited){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vertex);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ArrayList<Integer> curr_adj = adj[curr];
            visited[vertex]=true;
            for(int element : curr_adj){
                if(!visited[element]){
                    queue.offer(element);
                    visited[element] = true;

                }
            }

        }

    }
}
