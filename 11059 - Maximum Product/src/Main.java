import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by AhmedAmr on 11/13/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int c = 1;
        while(in.ready()){
            ArrayList<String> line = readStrings(nextLine(in));
            line = readStrings(nextLine(in));
            ArrayList<Integer> list = new ArrayList<>();
            for (String s : line) {
                list.add(Integer.parseInt(s));
            }
            System.out.print("Case #"+c+": ");
            long res = maxProduct(list,0);
            if(res>0)
             System.out.print("The maximum product is " + res + ".\n");
            else
                System.out.print("The maximum product is 0.\n");
            System.out.println();
            c++;
        }
    }
    public static long maxProduct(ArrayList<Integer> list,int i){
        if(list.size()== i-1) return list.get(0);
        long max = Long.MIN_VALUE;
        long product = 1;
        for (int j = i; j <list.size() ; j++) {
            product*=list.get(j);
            if(product>max)max=product;
        }
        return Math.max(max,maxProduct(list,i+1));
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
