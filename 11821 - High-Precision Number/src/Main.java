import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/24/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(line.get(0));
        for (int i = 0; i < t; i++) {
            line = readStrings(in.readLine());
            BigDecimal res = BigDecimal.ZERO;
            while(!line.get(0).equals("0")){
                res = res.add(new BigDecimal(line.get(0)));
                line = readStrings(in.readLine());
            }
            String temp = res.toPlainString();
            out.append(temp.substring(0,removeTrailing(temp)));
            out.append("\n");
            out.flush();
        }
    }


    public static int removeTrailing(String s){
        char[] arr = s.toCharArray();
        int l = arr.length;
        int last = l;
        for (int i = l-1; i >0; i--) {
            if(arr[i]=='.'){
                last--;
                return last;
            }else if(arr[i] == '0'){
                last--;
            }else{
                return last;
            }
        }
        return last;
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
