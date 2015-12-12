import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 11/9/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        int t = Integer.parseInt(line.get(0));
        for (int i = 0; i < t; i++) {
            line = readStrings(nextLine(in));
            int res=Integer.MAX_VALUE;
            ArrayList<Integer> list = getInts(line);
            list.remove(0);
            for (Integer integer2 : list) {
                int temp = 0;
                for (Integer integer : list) {
                    temp+=Math.abs(integer-integer2);
                }
                if(temp<res)res=temp;
            }


            System.out.println(res);
        }
    }

    public static ArrayList<Integer> getInts(ArrayList<String>list){
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : list) {
            res.add(Integer.parseInt(s));
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

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
