import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/31/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings((in.readLine()));
        int size = Integer.parseInt(line.get(0));
        for (int i = 0; i < size; i++) {
            line = readStrings((in.readLine()));
            int l = line.size();
            int[] input = getInts(line);
            long max = 1;
            for (int j = 0; j < l; j++) {
                for (int k = j+1; k < l; k++) {
                    long res = gcd(input[j],input[k]);
                    if(res>max)max=res;
                }
            }
            System.out.println(max);
        }
    }

    public static long gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

    public static int[] getInts(ArrayList<String> list){
        int[] arr = new int[list.size()];
        int i = 0;
        for (String s : list) {
            arr[i]=Integer.parseInt(s);
            i++;
        }
        return arr;
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
