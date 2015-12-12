import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/24/15.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String ERROR = "  ERROR";
        ArrayList<String> line = readStrings(in.readLine());
        while(line!=null) {
            BigInteger num = new BigInteger(line.get(0), Integer.parseInt(line.get(1)));
            String res = num.toString(Integer.parseInt(line.get(2)));
            int length = res.length();
            if (length > 7) {
                System.out.println(ERROR);

            } else {
                for (int i = 0; i < 7 - length; i++) {
                    System.out.print(" ");
                }
                System.out.print(res.toUpperCase());
                System.out.println();
            }
            if(!in.ready()){
                break;
            }
            line = readStrings(in.readLine());
        }
    }

    public static ArrayList<String> readStrings(String line) {
        if (line == null) return null;
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }


}
