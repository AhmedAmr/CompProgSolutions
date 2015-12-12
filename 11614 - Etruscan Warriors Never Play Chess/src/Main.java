import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/6/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int size = Integer.parseInt(in.readLine());
        for (int i = size; i > 0 ; i--) {
            long n = Long.parseLong(in.readLine());
            double temp1 = java.lang.Math.sqrt(1 + 8 * n);
            out.append(String.valueOf((long)(((-1+temp1)*1.0)/2)));
            out.append("\n");
            out.flush();
            }
        }
}
