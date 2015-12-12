import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AhmedAmr on 11/18/15.
 */
public class Main {
    static ArrayList<Integer[]> res = new ArrayList<>();
    static boolean[] visited;
    static int MAX;
    static Integer[] current;
    static int c = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(true) {
            ArrayList<String> line = readStrings(nextLine(in));
            int l = Integer.parseInt(line.get(0));
            MAX=l;
            visited = new boolean[l+1];
            current = new Integer[l];
            current[0]=1;
            visited[0]=true;
            res  = new ArrayList<>();
            solve(1);
            print(out);
            if(in.ready()) System.out.println();
            else break;
        }
    }

    public static void print(PrintWriter out){
        out.append("Case ");
        out.append(String.valueOf(c));
        c++;
        out.append(":\n");
        for (Integer[] re : res) {
            for (int i = 0; i < re.length; i++) {
                if(i==0){
                    out.append(String.valueOf(re[i]));
                }else{
                    out.append(" ");
                    out.append(String.valueOf(re[i]));
                }
            }
            out.append("\n");
        }
        out.flush();
    }



    public static void solve(int i){
        //found a candidate solution
        if(i == MAX){
            if(isPrime(current[0]+current[MAX-1])){
                res.add(Arrays.copyOf(current,current.length));
            }
        }
        for (int j = 2; j < MAX+1 ; j++) {
         if(isAcceptedState(j,current[i-1])){
            //take this state
             visited[j] = true;
             current[i]=j;

             //recurse
             solve(i+1);

             //undo
             visited[j]=false;
         }
        }
    }

    public static boolean isAcceptedState(int k , int last){
        return (!visited[k]&&isPrime(last+k));
    }


    public static boolean isPrime(int n){
        if(n==2)return true;
        if(n==3)return true;
        if(n==5)return true;
        if(n%2==0)return false;
        if(n%3==0)return false;
        if(n%5==0)return false;
        int size = (int) Math.ceil(Math.sqrt(n));
        for (int i = 7; i <= size; i++) {
            if(n%i==0)return false;
        }
        return true;
    }


    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
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
