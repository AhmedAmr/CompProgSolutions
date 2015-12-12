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
            long base = getLongs(line).get(0);
            line = readStrings(in.readLine());
            ArrayList<Long> coef = getLongs(line);
            int n = coef.size();
                long sum = 0;
                long mult = 1;
                long nM = 1;
                for (int i = n-2; i >-1; i--) {
                    sum+=nM*coef.get(i)*mult;
                    nM++;
                    mult*=base;
                }
            System.out.println(sum);
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
