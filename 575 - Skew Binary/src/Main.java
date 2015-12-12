import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/29/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            char[] num = line.get(0).toCharArray();
            int size = num.length;
            int res = 0;
            int fact = 2;
            for (int i = size-1; i >=0; i--) {
                if(num[i]!='0'){
                    res+=Integer.parseInt(String.valueOf(num[i]))*(fact-1);
                }
                fact*=2;
            }
            System.out.println(res);
            line = readStrings(in.readLine());
        }
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
