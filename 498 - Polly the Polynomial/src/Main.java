import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/30/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            ArrayList<String> line = readStrings(in.readLine());
            ArrayList<Long> coef = getLongs(line);
            line = readStrings(in.readLine());
            ArrayList<Long> bases = getLongs(line);
            ArrayList<Long> res = new ArrayList<>();
            int n = coef.size();
            for (Long integer : bases) {
                long sum = 0;
                long mult = 1;
                for (int i = n-1; i >-1; i--) {
                    sum+=coef.get(i)*mult;
                    mult*=integer;
                }
                res.add(sum);
            }
            int size = res.size();
            System.out.print(res.get(0));
            for (int i = 1; i <size ; i++) {
                System.out.print(" "+res.get(i));
            }
            System.out.println();
            if(!in.ready()) break;
        }
    }

    public static ArrayList<Long> getLongs(ArrayList<String> list){
        ArrayList<Long> res = new  ArrayList<>();
        for (String s : list) {
            res.add(Long.parseLong(s));
        }
        return res;
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
