import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by AhmedAmr on 11/4/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        int l = Integer.parseInt(line.get(0));
        for (int i = 0; i < l; i++) {
            line = readStrings(nextLine(in));
            long n = Long.parseLong(line.get(0));
            int k = (int)Math.ceil(9876543210.0/n);
            for (int j = 1 ; j <=k ; j++) {
                if(!isRepeted(j)){
                    long s1 = j*n;
                    if(!isRepeted(s1)){
                        System.out.println(s1+" / "+j+" = "+n);
                    }
                }
            }
            if(i<l-1){
                System.out.println();
            }
        }
    }

    public static boolean isRepeted(long l){
        char[] arr = String.valueOf(l).toCharArray();
        int length = arr.length;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if(set.contains(arr[i]))return true;
            set.add(arr[i]);
        }
        return false;
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
