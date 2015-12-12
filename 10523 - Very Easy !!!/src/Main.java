import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/15/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()){
            ArrayList<String> line = readStrings(in.readLine());
            BigInteger n = new BigInteger(line.get(0));
            BigInteger a = new BigInteger(line.get(1));
            BigInteger res;
            n = n.add(BigInteger.ONE);
            if(n.compareTo(BigInteger.ZERO)==0||a.compareTo(BigInteger.ZERO) == 0){
                System.out.println(0);
            }else if (a.compareTo(BigInteger.ONE)==0) {
                res = n.multiply(n.subtract(BigInteger.ONE)).divide(new BigInteger(String.valueOf(2)));
                System.out.println(res);
            }
             else{
                    BigInteger an = a.pow(n.intValue());
                    res = a.subtract(n.multiply(an));
                    res = res.add(n.subtract(BigInteger.ONE).multiply(an.multiply(a)));
                    BigInteger temp = BigInteger.ONE.subtract(a);
                    res = res.divide(temp.pow(2));
                    System.out.println(res);
                }
            }

        }

    public static ArrayList<String> readStrings(String line){
        String[] arr =  line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(s);
        }
        return res;
    }

}
