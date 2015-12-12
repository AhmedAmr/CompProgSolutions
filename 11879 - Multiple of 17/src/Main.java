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
        while(!line.get(0).equals("0")){
            if(new BigInteger(line.get(0)).mod(new BigInteger(String.valueOf(17))).equals(BigInteger.ZERO)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            line = readStrings(nextLine(in));
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

    public static String nextReadyLine(BufferedReader in) throws IOException {
        if(!in.ready()) return null;
        String line = in.readLine();
        while(line.isEmpty()) {
            if(!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while(line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }
}
