import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by AhmedAmr on 10/7/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer>list = readInts(in.readLine());
        out.append("PERFECTION OUTPUT\n");
        out.flush();
        boolean end = false;
        while(true) {
            for (Integer n : list) {
                if (n != 0) {
                    print(out, n, solve(n));
                }else {
                  end = true;
                    break;
                }
            }
            if(!end) list = readInts(in.readLine());
            else break;
        }
        out.append("END OF OUTPUT\n");
        out.flush();
        out.close();
    }

    public static TreeSet<Integer> factorize(Integer number){
        int step = 1;
        if(number%2 != 0) step=2;
        TreeSet<Integer> list = new TreeSet<>();
        int size = (int) Math.sqrt(number.doubleValue() + 1);
        for (int i = 1; i <=size ; i+=step) {
            if(number%i == 0){
                list.add(number/i);
                list.add(i);
            }
        }
        list.remove(number);
        return list;
    }

    public static int solve(int n){
        TreeSet<Integer> list= factorize(n);
        int sum = 0;
        for (Integer integer : list) {
            sum+=integer;
            if(sum>n)return 1;
        }
        if(sum < n) return -1;
        return 0;

    }
    public static void print(PrintWriter out, int n , int sol){
        int size = String.valueOf(n).length();
        for (int i = 0; i <5-size ; i++) {
            out.append(" ");
        }
        out.append(String.valueOf(n));
        out.append("  ");
        if(sol == 0) out.append("PERFECT\n");
        else if(sol > 0) out.append("ABUNDANT\n");
        else out.append("DEFICIENT\n");
        out.flush();
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }
}
