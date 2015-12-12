import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 9/9/15.
 */
public class Main {


    public static void main(String[] args) throws IOException {

//        PrintWriter n2 = new PrintWriter(System.out);
//
//        n2.append(String.valueOf(2000));
//        n2.append(" ");
//        n2.append(String.valueOf(3));
//        n2.append("\n");
//        n2.flush();
//        for (int i = -1000; i < 1000; i++) {
//            n2.append(String.valueOf(i));
//            n2.append("\n");
//            n2.flush();
//        }
//        n2.append("0 0");
//        n2.flush();
//        n2.close();

        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] line = in.readLine().split(" ");
        int n= Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        while(n!=0 && m!=0) {
            ArrayList<Node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(in.readLine());
                Node node = new Node();
                node.num = num;
                node.mod = num % m;
                list.add(node);
            }

                Collections.sort(list);
            out.append(String.valueOf(n));
            out.append(" ");
            out.append(String.valueOf(m));
            out.append("\n");
            out.flush();
            for (Node node : list) {
                out.append(String.valueOf(node.num));
                out.append("\n");
                out.flush();
            }
             line = in.readLine().split(" ");
             n= Integer.parseInt(line[0]);
             m = Integer.parseInt(line[1]);
        }
        out.append("0 0");
        out.append("\n");
        out.flush();
    }

    static class Node implements  Comparable<Node>{
        int num;
        int mod;


        @Override
        public int compareTo(Node o) {
            if(this.mod > o.mod) return 1;
            if(this.mod < o.mod) return -1;

            boolean isEven1 = this.num%2==0;
            boolean isEven2 = o.num%2==0;

            if(isEven1&&isEven2){
                if(this.num > o.num) return 1;
                if(this.num < o.num) return -1;
                return 0;
            }
            if(!isEven1&&!isEven2){
                if(this.num > o.num) return -1;
                if(this.num < o.num) return 1;
                return 0;
            }
            if(isEven1) return 1;
            return -1;

        }
    }

}
