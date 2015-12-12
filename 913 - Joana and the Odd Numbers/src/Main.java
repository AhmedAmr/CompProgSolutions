import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AhmedAmr on 10/12/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()){
            long n = Long.parseLong(in.readLine());
            long x = (n+1)/2;
            x = x*x;
            x = 6*x-9;
            System.out.println(x);
        }
    }
}
