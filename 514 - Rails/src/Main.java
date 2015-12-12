import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by AhmedAmr on 9/21/15.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        while(n!=0){
            String line[] = in.readLine().split(" ");
            while(Integer.parseInt(line[0])!=0){
                System.out.println(isMergable(n,line));
                line = in.readLine().split(" ");
            }
            n = Integer.parseInt(in.readLine());
            if(n!=0)
            System.out.println();
        }
    }

    public static String isMergable(int n , String[] line){
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int size = line.length;
        for (int i = 0; i <size; i++) {
            q.add(Integer.parseInt(line[i]));
        }
        for (int i = 1; i <=n; i++) {
            s.add(i);
            while(!s.isEmpty()){
                if(s.peek() == q.peek()){
                    s.pop();
                    q.poll();
                }else break;
            }
        }
        if(s.isEmpty()){
            return "Yes";
        }else{
            return "No";
        }
    }
}
