import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/14/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()){
            ArrayList<String> list = read(in.readLine());
            BigInteger x = new BigInteger(list.get(0));
            BigInteger y = new BigInteger(list.get(2));
            if(list.get(1).equals("%")){
                System.out.println(x.mod(y).toString());
            }else{
                System.out.println(x.divide(y).toString());
            }
        }
    }

    public static ArrayList<String> read(String line){
        String[] arr =  line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(s);
        }
        return res;
    }
}
