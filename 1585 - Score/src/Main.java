import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/31/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        int l = Integer.parseInt(line.get(0));
        for (int i = 0; i < l; i++) {
            line = readStrings(in.readLine());
            char[] arr = line.get(0).toCharArray();
            int size = arr.length;
            int sum = 0;
            int os = 0;
            boolean cons = false;
            for (int j = 0; j < size; j++) {
                if(arr[j]=='O'){
                    if(!cons) cons =true;
                    os++;
                    sum+=os;
                }else{
                    if(cons) {
                        cons=false;
                        os=0;
                    }
                }

            }
            System.out.println(sum);
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
