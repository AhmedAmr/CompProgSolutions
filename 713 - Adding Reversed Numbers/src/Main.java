import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by AhmedAmr on 10/14/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i <n ; i++) {
            String line[] = in.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                line[j]=new StringBuffer(line[j]).reverse().toString();
            }
            BigInteger x = new BigInteger(line[0]);
            BigInteger y = new BigInteger(line[1]);
            x = x.add(y);
            y = new BigInteger(new StringBuffer(x.toString()).reverse().toString());
            System.out.println(y.toString());
        }

    }
}
