import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 9/30/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        Stack<Integer>s = new Stack<>();
        Queue<Integer>q = new LinkedList<>();
        ArrayList<Integer> input;
        while((line=in.readLine()) != null){
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;
            int n = Integer.parseInt(line);
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n,Collections.reverseOrder());
            s.clear();
            q.clear();
            for (int i = 0; i < n; i++) {
                input = readInts(in.readLine());
                int v = input.get(1);
                if(input.get(0)==1){
                    s.push(v);
                    q.add(v);
                    pq.add(v);
                }else {
                    if (isStack) {
                        if (s.isEmpty()) isStack = false;
                        else {
                            if (s.peek() != v) isStack = false;
                            else s.pop();
                        }
                    }
                    if (isQueue) {
                        if (q.isEmpty()) isQueue = false;
                        else {
                            if (q.peek() != v) isQueue = false;
                            else q.poll();
                        }
                    }
                    if (isPQ) {
                        if (pq.isEmpty()) isPQ = false;
                        else {
                            if (pq.peek() != v) isPQ = false;
                            else pq.poll();

                        }
                    }
                }
            }
            if(!isStack&&!isQueue&&!isPQ){
                out.append("impossible\n");
            }else if(isStack&&!isQueue&&!isPQ){
                out.append("stack\n");
            }else if(!isStack&&isQueue&&!isPQ){
                out.append("queue\n");
            }else if(!isStack&&!isQueue&&isPQ){
                out.append("priority queue\n");
            }else{
                out.append("not sure\n");
            }
            out.flush();
        }
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

}
