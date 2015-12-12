import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/14/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()){
            ArrayList<String> list = read(in.readLine());
            BigDecimal x = new BigDecimal(list.get(0));
            int y = Integer.parseInt(list.get(1));
            x = x.pow(y);
            System.out.println(removeTrailing(x.toPlainString()));
        }
    }

    public static ArrayList<String> read(String line){
        String[] arr =  line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String removeTrailing(String res){
        char[] arr = res.toCharArray();
        int start = 0;
        int size = arr.length;
        int end = size;
        for (int i = 0; i <size; i++) {
            if(arr[i]=='0') start++;
            else break;
        }
        for (int i = size-1; i >=1 ; i--) {
            if(arr[i]=='0')end--;
            else if(arr[i]=='.'){
                end--;
                break;
            }else break;
        }
        return res.substring(start,end);
    }
}
