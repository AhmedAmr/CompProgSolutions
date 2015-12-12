import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 9/9/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int m = Integer.parseInt(in.readLine());
        while(m!=0){
            out.append(String.valueOf(getNext(m)));
            out.append("\n");
            out.flush();
            m = Integer.parseInt(in.readLine());
        }
    }


    public static long getNext(int m){
        long result=Long.MAX_VALUE;
        for (int i = 0; i <= 32; i++) {
            for (int j = 0; j < 32; j++) {
                long temp = (long)(Math.pow(2,i)*Math.pow(3,j));
                if(temp >= m && temp < result) {
                    result = temp;
                    break;
                }
            }
        }
        return result;
    }
}
