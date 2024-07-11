import java.io.*;
import java.util.*;


class Baek_1260 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] params =  Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int verticies = params[0];
        int edges = params[1];
        int start_vertex = params[2];
        ArrayList<Integer>[] adj = new ArrayList[verticies+1];

        for(int i=0 ; i< adj.length ; i ++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < edges ; i++){
            String[] edge = br.readLine().split(" ");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);

            adj[from].add(to);
            adj[to].add(from);
        }

        DFS(adj, start_vertex);
        BFS(adj, start_vertex);

    }

    public void BFS(ArrayList<Integer>[] adj, int start_vertex){
        String rv = "";
        boolean[] visited = new boolean[adj.length];
        for(boolean v : visited){
            v = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[start_vertex] = true;
        queue.offer(start_vertex);

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            rv = rv + Integer.toString(vertex) + " ";
            adj[vertex].sort((a,b) -> a-b);
            for(int adj_vertex : adj[vertex]){
                if(visited[adj_vertex] == false){
                    visited[adj_vertex] = true;
                    queue.offer(adj_vertex);
                }
            }
        }

        System.out.println(rv);


    }

    public void DFS(ArrayList<Integer>[] adj, int start_vertex){

        Stack<Integer> stack = new Stack<>();
        String rv = "";
        boolean[] visited = (new boolean[adj.length]);
        for(boolean visit : visited){
            visit = false;
        }

        stack.push(start_vertex);

        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(!visited[vertex]) {
                visited[vertex] = true;
                rv = rv + vertex + " ";
            }
            adj[vertex].sort((a,b) -> b-a);
            System.out.println(adj[vertex]);
            for(int adj_vertex : adj[vertex]){
                if(!visited[adj_vertex]){
                    stack.push(adj_vertex);
                }
            }
        }
        System.out.println(rv);

    }
}