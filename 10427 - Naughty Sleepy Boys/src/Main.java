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
        while(true){
            ArrayList<String> list = readStrings(in.readLine());
            System.out.println(solve(Integer.parseInt(list.get(0))));
            if(!in.ready()){
                break;
            }
        }
    }

    public static long solve(int n){
        if(n<10)return n;
        n-=9;
        int digits=2;
        long start =10;
        while(true){
            long end = digits*(((start*10-1)-start)+1);
            if(n>end)n-=end;
            else{
                int rem= n%digits;
                n= (int)Math.ceil(n * 1.0 / digits);
                start+=(n-1);
                String s = String.valueOf(start);
                if(rem==0)return Long.parseLong(s.charAt(digits - 1) + "");
                else return Long.parseLong(s.charAt(rem - 1) + "");
            }
            start*=10;
            digits++;
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
