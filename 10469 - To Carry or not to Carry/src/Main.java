import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/4/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){
            String[] arr = in.readLine().split(" ");
            out.append(String.valueOf(Long.parseLong(arr[0])^Long.parseLong(arr[1])));
            out.flush();
        }
    }
}
