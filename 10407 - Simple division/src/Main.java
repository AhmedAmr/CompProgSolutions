import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by AhmedAmr on 10/27/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            ArrayList<BigInteger> list = new ArrayList<>();
            int size = line.size();
            for (int i = 1; i <size-1 ; i++) {
                list.add(new BigInteger(line.get(i)).subtract(new BigInteger(line.get(i-1))).abs());
            }
            size = list.size();
            BigInteger res = list.get(0);
            for (int i = 1; i <size; i++) {
                res = res.gcd(list.get(i));
            }
            System.out.println(res.toString());
            line = readStrings(in.readLine());
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
