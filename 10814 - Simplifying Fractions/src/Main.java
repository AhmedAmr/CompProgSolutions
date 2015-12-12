import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/24/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int s = Integer.parseInt(line.get(0));
        for (int i = 0; i < s; i++) {
            line = readStrings(in.readLine());
            BigInteger n1 = new BigInteger(line.get(0));
            BigInteger n2   = new BigInteger(line.get(2));
            simplify(n1,n2,out);
        }
    }

    public static void simplify(BigInteger n1,BigInteger n2,PrintWriter out){
        BigInteger res = n1.gcd(n2);
        if(res.equals(BigInteger.ONE)){
            out.append(n1.toString());
            out.append(" / ");
            out.append(n2.toString());
            out.append("\n");
            out.flush();
            return;
        }else{
            simplify(n1.divide(res),n2.divide(res),out);
        }
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

}
