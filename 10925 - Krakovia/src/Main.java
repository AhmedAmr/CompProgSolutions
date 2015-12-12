import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/18/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        int count = 1;
        while(!line.get(0).equals("0")){
            BigInteger sum = BigInteger.ZERO;
            int items = Integer.parseInt(line.get(0));
            int f = Integer.parseInt(line.get(1));
            for (int i = 0; i <items; i++) {
                line = readStrings(in.readLine());
                sum = sum.add(new BigInteger(line.get(0)));
            }
            BigInteger res = sum.divide(new BigInteger(String.valueOf(f)));
            System.out.println("Bill #"+count+" costs "+sum+": each friend should pay "+res+"\n");
            count++;
            line = readStrings(nextLine(in));
        }
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while(line.isEmpty()) {
            line = in.readLine();
        }
        return line;
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
