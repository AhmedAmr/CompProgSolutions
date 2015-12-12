import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 10/12/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(in.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            int size = (int)Math.ceil(Math.sqrt(n));
            for (int j = size; j > 0; j--) {
                int x =(int)(n-Math.pow(j,2));
                if(x>0){
                    double res = x/(Math.sqrt(n-x));
                    if(res == (int)res){
                        list.add(x);
                    }
                }
            }
            System.out.print("Case " + (i + 1) + ":");
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();

        }
    }
}
