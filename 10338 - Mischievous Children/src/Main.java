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
        ArrayList<String> line = readStrings(in.readLine());
        int size = Integer.parseInt(line.get(0));
        for (int i = 1; i <= size; i++) {

            line = readStrings(in.readLine());
            int x = line.get(0).length();
            System.out.println("Data set "+i+": "+factorial(x).divide(getRep(line.get(0),x)));
        }
    }

    public static BigInteger getRep(String s,int l){
        HashMap<Character,Integer> rep = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < l; i++) {
            if(!rep.containsKey(arr[i]))rep.put(arr[i],1);
            else{
                rep.put(arr[i],rep.get(arr[i])+1);
            }
        }
        BigInteger b = BigInteger.ONE;
        for (Integer integer : rep.values()) {
            if(integer>1)b=b.multiply(factorial(integer));
        }
        return b;
    }

    public static BigInteger factorial(int l){
        if(l==0||l==1)return BigInteger.ONE;
        if(map.containsKey(l))return map.get(l);
        BigInteger b;
        if(last==0) b= BigInteger.ONE;
        else b=map.get(last);
        for (int i = last+1; i <=l ; i++) {
            b=b.multiply(new BigInteger(String.valueOf(i)));
            map.put(i,b);
        }
        if(last<l)last=l;
        return b;
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
