import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 * Created by AhmedAmrOn on 9/30/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n  = Integer.parseInt(in.readLine());
        while(n!=0){
            out.append(String.valueOf(run(readInts(in.readLine()))));
            out.append("\n");
            out.flush();
            n  = Integer.parseInt(in.readLine());
        }

    }
    public static PriorityQueue<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        PriorityQueue<Integer> res = new PriorityQueue<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static int run(PriorityQueue<Integer> q){
        int res = 0;
        while(q.size()>1){
            int sum = q.poll()+q.poll();
            q.add(sum);
            res+=sum;
        }
        return res;
    }
}
