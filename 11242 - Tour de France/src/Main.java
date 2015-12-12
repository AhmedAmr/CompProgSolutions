import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 11/14/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(!line.get(0).equals(0)){
            int f = line.get(0);
            int r = line.get(1);
            ArrayList<Integer> front = readInts(nextLine(in));
            ArrayList<Integer> rear = readInts(nextLine(in));
            ArrayList<Double> driveRatios  = new ArrayList<>();
            for (Integer n : rear) {
                for (Integer m : front) {
                    driveRatios.add(n*1.0/m);
                }
            }
            Collections.sort(driveRatios);;
            int l = driveRatios.size();
            double maxSpread = 0;
            for (int i = l-1; i>0 ; i--) {
                double spread = driveRatios.get(i)/driveRatios.get(i-1);
                if(spread>maxSpread)maxSpread=spread;
            }
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(maxSpread));
            line= readInts(nextLine(in));
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



    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
