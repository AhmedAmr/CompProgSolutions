import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by AhmedAmr on 9/30/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = in.readLine();
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] counts = new int[3001];
        while(!line.equals("#")){
            ArrayList<String> s = getTokens(line);
            Node n = new Node();
            n.id = Integer.parseInt(s.get(1));
            n.v = Integer.parseInt(s.get(2));
            counts[n.id] = n.v;
            q.add(n);
            line = in.readLine();
        }
        int k = Integer.parseInt(in.readLine());
        for (int i = 0; i < k; i++) {
            Node min = q.poll();
            out.append(String.valueOf(min.id));
            out.append("\n");
            min.v+=counts[min.id];
            q.add(min);
        }
        out.flush();
    }

    public static ArrayList<String> getTokens(String line){
        String[] arr = line.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) list.add(s);
        }
        return list;
    }

    public static class Node implements Comparable<Node>{
        int v ;
        int id;

        @Override
        public int compareTo(Node o) {
            if(this.v < o.v)return -1;
            if(this.v > o.v)return 1;
            if(this.id< o.id)return -1;
            if(this.id>o.id)return 1;
            return 0;
        }
    }
}
