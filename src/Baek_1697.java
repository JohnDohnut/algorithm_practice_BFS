import java.io.*;
import java.util.*;

public class Baek_1697 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] args = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = args[0];
        int dest = args[1];
        int [] times = new int[100001];
        Arrays.fill(times, 0);
        BFS(start, dest, times);
        System.out.println(times[dest]);


    }
    public void BFS(int start, int dest, int[] times){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            int[] movement = new int[] {curr+1, curr-1, curr*2};
            if(curr == dest){
                return;
            }
            for(int i=0; i<3; i++){
                if(isReachable(movement[i]) && times[movement[i]] == 0){
                    queue.offer(movement[i]);
//                    if(times[movement[i]] == 0){
//                        times[movement[i]] = times[curr] + 1;
//                    }
                    times[movement[i]] = times[curr] + 1;

                }

            }
        }
    }

    public boolean isReachable(int position){
        if (position < 0 || position > 100000){
            return false;
        }
        return true;
    }
}
