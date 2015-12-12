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
            String input = in.readLine();
            String line[] = input.split(" ");
            BigInteger x = new BigInteger(line[0]);
            BigInteger y = new BigInteger(line[2]);
            BigInteger res;
            if(line[1].equals("+")){
                 res = x.add(y);
            }else{
                res = x.multiply(y);
            }
            System.out.println(input);
            if(x.bitLength()>31){
                System.out.println("first number too big");
            }
            if(y.bitLength()>31){
                System.out.println("second number too big");
            }
            if(res.bitLength()>31){
                System.out.println("result too big");
            }
        }
    }
}
