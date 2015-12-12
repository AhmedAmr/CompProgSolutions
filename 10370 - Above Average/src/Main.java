import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/7/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        ArrayList<Integer> line;
        for (int i = 0; i < t; i++) {
            line = readInts(in.readLine());
            int n = line.get(0);
            int size = n-1;
            line.remove(0);
            int[] arr= new int[n];
            while(size>-1){
                while(line.isEmpty()){
                    line = readInts(in.readLine());
                }
                for (int temp : line) {
                    arr[size]=temp;
                    size--;
                }
                line.clear();
            }
            double sum = 0;
            for (int i1 : arr) {
                sum+=i1;
            }
            sum /= n;
            double count = 0;
            for (int i1 : arr) {
                if(i1 > sum) count++;
            }
            count /= n;
            DecimalFormat df = new DecimalFormat("#0.000%\n");
            out.append(String.valueOf(df.format(count)));
            out.flush();
        }

    }


    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }
}
