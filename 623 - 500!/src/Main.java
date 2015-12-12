import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AhmedAmr on 11/1/15.
 */
public class Main {
    static HashMap<Integer,BigInteger> map = new HashMap<>();
    static int last = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            ArrayList<String> line = readStrings((in.readLine()));
            String res = factorial(line.get(0));
            System.out.print(line.get(0));
            System.out.print("!");
            System.out.println();
            System.out.println(res);
            if(!in.ready())break;
        }
    }


    public static String factorial(String n){
        int l = Integer.parseInt(n);
        if(l==0||l==1)return "1";
        if(map.containsKey(l))return map.get(l).toString();
        BigInteger b;
        if(last==0) b= BigInteger.ONE;
        else b=map.get(last);
        for (int i = last+1; i <=l ; i++) {
            b=b.multiply(new BigInteger(String.valueOf(i)));
            map.put(i,b);
        }
        if(last<l)last=l;
        return b.toString();
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
