import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by AhmedAmr on 12/28/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int n  = line.get(0);
        for (int i = 0; i < n; i++) {
            ArrayList<Node> list = new ArrayList<>();
            line = readInts(nextLine(in));
            int j= line.get(0);
            for (int k = 1; k < j+1; k++) {
                line = readInts(nextLine(in));
                int t = line.get(0);
                int s = line.get(1);
                list.add(new Node(t,s,k));
            }
            Collections.sort(list);
            System.out.print(list.get(0).id);
            list.remove(0);
            for (Node node : list) {
                System.out.print(" "+node.id);
            }
            System.out.println();
            if(i<n-1) System.out.println();


        }
    }
    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }


    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
class Node implements Comparable<Node>{
    int t;
    int s;
    int id;
    double value;
    public Node(int t, int s, int id) {
        this.t = t;
        this.s = s;
        this.id = id;
        this.value = this.s*1.0/this.t;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value>o.value) return -1;
        if(this.value<o.value) return 1;
        if(this.id<o.id)return -1;
        if(this.id>o.id)return 1;
        return 0;

    }
}
