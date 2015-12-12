import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/13/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        int c = 1;
        while(!line.get(0).equals("0")){
        int l  = Integer.parseInt(line.get(0));
        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            input.add(Integer.parseInt(readStrings(nextLine(in)).get(0)));
        }
            line = readStrings(nextLine(in));
            int k = Integer.parseInt(line.get(0));
            System.out.println("Case "+c+":");
            for (int i = 0; i < k; i++) {
                int q = Integer.parseInt(readStrings(nextLine(in)).get(0));
                System.out.println("Closest sum to "+q+" is "+closestSum(q,input)+".");
            }
            line = readStrings(nextLine(in));
            c++;
        }
    }

    public static int closestSum(int n , ArrayList<Integer> list){
        ArrayList<Integer> sums = new ArrayList<>();
        int l = list.size();
        for (int i = 0; i < l ; i++) {
            for (int j = i+1; j <l ; j++) {
               if(list.get(i)!=null&&list.get(j)!=null){
                   sums.add(list.get(i)+list.get(j));
               }
            }
        }
        int diff = Integer.MAX_VALUE;
        int res = 0 ;
        for (Integer sum : sums) {
            if(Math.abs(sum-n)<diff){
                diff = Math.abs(sum-n);
                res = sum;
            }
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
