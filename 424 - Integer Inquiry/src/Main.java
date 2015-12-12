import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by AhmedAmr on 10/13/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BigInteger res = BigInteger.ZERO;
        BigInteger x = new BigInteger(in.readLine());
        while(!x.equals(BigInteger.ZERO)){
            res = res.add(x);
            x = new BigInteger(in.readLine());
        }
        System.out.println(res);

    }
}
