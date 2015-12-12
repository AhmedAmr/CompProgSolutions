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
        while(in.ready()){
            BigInteger res = new BigInteger(in.readLine());
            res = res.multiply(new BigInteger(in.readLine()));
            System.out.println(res);
        }
    }
}
