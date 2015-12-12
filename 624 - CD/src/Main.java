import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/18/15.
 */
public class Main {
    static int MAX =0;
    static int SIZE = 0;
    static int SUM = 0;
    static ArrayList<Integer> res  = new ArrayList<>();
    static ArrayList<Integer> line = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()) {
           line = readInts(nextLine(in));
            MAX = line.get(0);
            SIZE = line.size();
            solve(2, 0,new ArrayList<Integer>());
            print(out);
            res = new ArrayList<>();
            SUM=0;
        }

    }

    public static void print(PrintWriter out){
        for (Integer re : res) {
            out.append(String.valueOf(re));
            out.append(" ");
        }
        out.append("sum:");
        out.append(String.valueOf(SUM));
        out.append("\n");
        out.flush();
    }


    public static void solve(int i , int sumSoFar,ArrayList<Integer>items){
        if(sumSoFar>MAX)return;
        if(i>=SIZE||sumSoFar==MAX){
            if(sumSoFar>SUM){
                SUM = sumSoFar;
                res = new ArrayList<>(items);
            }else if(sumSoFar==SUM){
                if(res.size() <= items.size())
                    res = new ArrayList<>(items);
            }
            return;
        }
        solve(i+1,sumSoFar,new ArrayList<>(items));
        ArrayList<Integer>temp = new ArrayList<>(items);
        temp.add(line.get(i));
        solve(i+1,sumSoFar+line.get(i),temp);

        return;
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
