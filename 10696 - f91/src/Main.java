import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AhmedAmr on 10/12/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        while(n!=0){
            System.out.println("f91("+n+") = "+solve(n));
            n = Long.parseLong(in.readLine());
        }
    }

    public static long solve(long n){
        if(n>=101) return n-10;
        return solve(solve(n+11));
    }
}
