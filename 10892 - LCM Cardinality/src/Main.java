import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by AhmedAmr on 10/31/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings((in.readLine()));
        while(!line.get(0).equals("0")){
            long n = Long.parseLong(line.get(0));
            int card=0;
            ArrayList<Long> factors = sortedFactorize(n);
            int l = factors.size();
            for (int i = 0; i <l; i++) {
                long a = factors.get(i);
                for (int j = i; j <l ; j++) {
                    if(lcm(a,factors.get(j))==n)card++;
                }
            }
            System.out.println(line.get(0)+" "+card);
            line = readStrings((in.readLine()));
        }

    }

    public static long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }

    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

    public static ArrayList<Long> sortedFactorize(Long number){
        int step = 1;
        if(number%2 != 0) step=2;
        ArrayList<Long>list = new ArrayList<>();
        int size = (int) Math.sqrt(number.doubleValue() + 1);
        for (int i = 1; i <=size ; i+=step) {
            if(number%i == 0){
                long a = number/i;
                if(!list.contains(a))list.add(a);
                long b = i;
                if(!list.contains(b))list.add(b);
            }
        }
        return list;
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
