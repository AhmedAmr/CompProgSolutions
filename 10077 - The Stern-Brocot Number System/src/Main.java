import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/27/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            ArrayList<Integer> line = readInts(nextLine(in));
            if(line.get(0)==1 && line.get(1)==1)break;
            // initial setting
            Node left = new Node(0,1);
            Node right = new Node(1,0);
            Node mid = new Node(1,1);
            StringBuilder sb = new StringBuilder();
            Node value = new Node(line.get(0),line.get(1));
            int res = value.compareTo(mid);
            while(res!=0){
                if(res>0){
                    left = new Node(mid.top,mid.down);
                    sb.append('R');
                }else if(res<0){
                    sb.append('L');
                    right = new Node(mid.top,mid.down);
                }
                mid = Node.add(left,right);
                res = value.compareTo(mid);
            }
            System.out.println(sb.toString());
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
    int top ;
    int down;

    public Node(int top, int down) {
        this.top = top;
        this.down = down;
    }

    @Override
    public int compareTo(Node o) {
        int left = o.down*this.top;
        int right = o.top*this.down;
        if(left>right)return 1;
        if(left<right)return -1;
        return 0;
    }
    public static Node add(Node n,Node l){
        return new Node(n.top+l.top,n.down+l.down);
    }
}
