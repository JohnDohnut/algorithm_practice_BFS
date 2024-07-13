import java.util.*;
import java.io.*;
public class Baek_2606 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int verticies = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adj_list = new ArrayList[verticies+1];
        for(int i=0 ; i< adj_list.length ; i++){
            adj_list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edges; i++){
            int[] edge = Arrays.stream(br.readLine()
                    .split(" "))
                    .mapToInt(x -> Integer.parseInt(x))
                    .toArray();
            adj_list[edge[0]].add(edge[1]);
            adj_list[edge[1]].add(edge[0]);
        }

        bw.write(Integer.toString(BFS(adj_list)));
        bw.flush();
    }


    public int BFS(ArrayList<Integer>[] adj_list){
        int curr = 1;
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj_list.length];

        for(boolean v : visited){
            v = false;
        }

        visited[curr] = true;
        queue.offer(curr);

        while(!queue.isEmpty()){
            curr = queue.poll();
            for(int adj : adj_list[curr]){
                if(!visited[adj]){
                    visited [adj] = true;
                    queue.offer(adj);
                    count++;
                }
            }
        }
        return count;
    }
}