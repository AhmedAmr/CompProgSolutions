import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 9/18/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (in.ready()){
            long n = Long.parseLong(in.readLine());
            out.append(String.valueOf((long)Math.floor(n-1+log2(n-1))));
            out.append("\n");
            out.flush();
        }
    }

    public static double log2(long x){
        return Math.log10(x)/Math.log10(2);
    }
}
