import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AhmedAmr on 10/31/15.
 */
public class Main {
    static HashMap<Integer,BigInteger> map = new HashMap<>();
    static int last = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings((in.readLine()));
        int[] digits = new int[10];
        while(!line.get(0).equals("0")){
            char[] fac = factorial(line.get(0)).toCharArray();
            int l = fac.length;
            for (int i = 0; i <l; i++) {
                int x = fac[i]-48;
                digits[x]++;
            }
            print(line.get(0),digits);
            digits = new int[10];
            line = readStrings((in.readLine()));
        }

    }

    public static void print(String n,int arr[]){
        System.out.println(n+"! --");
        System.out.println("   (0)  "+arr[0]+"    (1)   "+arr[1]+"    (2)   "+arr[2]+"    (3)   "+arr[3]+"    (4)   "+arr[4]);
        System.out.println("   (5)  "+arr[5]+"    (6)   "+arr[6]+"    (7)   "+arr[7]+"    (8)   "+arr[8]+"    (9)   "+arr[9]);
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
