import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int p = Integer.parseInt(in.readLine());
        SortedSet<Node> set = new TreeSet<>();
        for (int i = 0; i < p; i++) {
            set.clear();
            int f = Integer.parseInt(in.readLine());
            for (int j = 0; j < f; j++) {
                int floor = Integer.parseInt(in.readLine());
                if(floor<0){
                    set.add(new Node(Math.abs(floor),true));
                }else{
                    set.add(new Node(floor,false));
                }
            }
            int result = 1;
            boolean color=false;
                if(!set.isEmpty()) {
                    color = set.first().color;
                }else{
                    result = 0;
                }
            while(!set.isEmpty()){
                Node n  = set.first();
                set.remove(set.first());
                if(color != n.color){
                    result++;
                    color = !color;
                }
            }
            out.append(String.valueOf(result));
            out.append("\n");
            out.flush();
        }
        out.close();

    }

    static class Node implements  Comparable<Node>{
        int value ;
        boolean color;

        public Node(int value , boolean color){
            this.value  = value;
            this.color = color;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value > o.value) return 1;
            if(this.value < o.value) return -1;
            return 0;
        }
    }
}
