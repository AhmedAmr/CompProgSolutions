import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 10/1/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<String,Node> map = new HashMap<>();

        int n = Integer.parseInt(in.readLine());
        in.readLine();
        for (int i = 0; i < n; i++) {
            map.clear();
            int counter = 0;
            String line = in.readLine();
            while(true){
                if(line == null) break;
                if(line.isEmpty())break;
                counter++;
                Node node ;
                if(map.containsKey(line)){
                    node = map.get(line);
                    node.f++;
                }else{
                    node =new Node();
                    node.name = line;
                }
                map.put(line,node);
                line = in.readLine();
            }
            ArrayList<Node> c = new ArrayList<>(map.values());
            Collections.sort(c);

            for (Node node : c) {
                out.append(node.name);
                out.append(" ");
                out.append(String.format("%.4f",((node.f*1.0)/counter)*100));
                out.append("\n");
            }
            if(i<n-1){
                out.append("\n");
            }
            out.flush();

        }
    }
    public static class Node implements Comparable<Node>
    {

        String name;
        double f = 1;


        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }
    }

}
