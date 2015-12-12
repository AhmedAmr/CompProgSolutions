import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/7/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line[] = in.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int i = 1;
        while(r!=0){
            int n = Integer.parseInt(line[1]);
            int res = solve(r, n);
            out.append("Case ");
            out.append(String.valueOf(i));
            out.append(": ");
            if(res<0){
                out.append("impossible\n");
            }else{
                out.append(String.valueOf(res));
                out.append("\n");
            }
            out.flush();
            line = in.readLine().split(" ");
            r = Integer.parseInt(line[0]);
            i++;
        }
    }

    public static int solve(int r , int n){
        if(n>r)return 0;
        double res = Math.ceil(((r-n)*1.0/n));
        if(res > 26 ) return -1;
        return (int)res;
    }



}
