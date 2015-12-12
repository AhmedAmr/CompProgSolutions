import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 9/9/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int x = Integer.parseInt(in.readLine());
        for (int i = 0; i < x; i++) {
            String[] line = in.readLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int c =Integer.parseInt(line[1]);
            int m = Integer.parseInt(line[2]);
            int n = Integer.parseInt(line[3]);
            HashMap<Character,Node> list = new HashMap<>();
            for (int j = 0; j < r; j++) {
                char[] row =  in.readLine().toCharArray();
                for (int k = 0; k < c; k++) {
                    if(list.get(row[k])!=null){
                        list.put(row[k],new Node(row[k],list.get(row[k]).rep+1));
                    }else{
                        list.put(row[k], new Node(row[k], 1));
                    }
                }
            }
            ArrayList<Node> list2 = new ArrayList<>(list.values());
            Collections.sort(list2);
            int max = list2.get(0).rep;
            int result = 0;
            for (Node node : list2) {
                if(node.rep == max)
                    result+=(max*m);
                else
                    result+=(node.rep*n);
            }
            out.append("Case ");
            out.append(String.valueOf((i+1)));
            out.append(": ");
            out.append(String.valueOf(result));
            out.append("\n");
            out.flush();
        }


    }


    static class Node implements Comparable<Node>{
        char c;
        int rep;


        public Node(char c , int rep ){
            this.c = c;
            this.rep=rep;
        }
        @Override
        public int compareTo(Node o) {
            if(this.rep > o.rep) return -1;
            if(this.rep < o.rep) return 1;
            return 0;
        }
    }


}
