import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AhmedAmr on 11/19/15.
 */
public class Main {
    static Boolean visited[];
    static int MAX ;
    static ArrayList<Boolean[]> res = new ArrayList<>();
    static ArrayList<Integer> input = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0){
            out.append("Sums of ");
            out.append(String.valueOf(line.get(0)));
            out.append(":\n");
            out.flush();
            MAX = line.get(1);
            int rem = line.get(0);
            visited = new Boolean[MAX];
            for (int i = 0; i < MAX; i++) {
                visited[i]=false;
            }
            line.remove(0);
            line.remove(0);
            input=line;
            solve(0, rem);
            print(out);
            line = readInts(nextLine(in));
        }
    }

    public static void print(PrintWriter out){
        if(res.size()==0)out.append("NONE\n");
        else {
            for (Boolean[] re : res) {
                int start = -1;
                for (int i = 0; i < MAX; i++) {
                    if (re[i]) {
                        start = i;
                        break;
                    }
                }


                out.append(String.valueOf(input.get(start)));
                for (int i = start + 1; i < MAX; i++) {
                    if (re[i]) {
                        out.append("+");
                        out.append(String.valueOf(input.get(i)));
                    }
                }
                out.append("\n");
            }
        }
           out.flush();

    }

    public static void solve(int i,int rem){
        //invalid case .. prune quickly
        if(rem<0)return;
        //found a result
        if(rem==0){
            res.add(Arrays.copyOf(visited,MAX));
            return;
        }
        //invalid case
        if(i==MAX)return;

        //do take this state
        visited[i]=true;

        // recurse
        solve(i+1,rem-input.get(i));

        // undo
        visited[i]=false;

        //don't take the state
        solve(i+1,rem);
    }


    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
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
