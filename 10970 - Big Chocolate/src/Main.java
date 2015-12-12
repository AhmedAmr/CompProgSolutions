import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AhmedAmr on 10/12/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(in.ready()){
            String [] line = in.readLine().split(" ");
            int n =  Integer.parseInt(line[0]);
            int m =  Integer.parseInt(line[1]);
            int cut1 =(n-1)+(m-1)*n;
            int cut2 = (m-1)+(n-1)*m;
             int res = Math.min(cut1,cut2);

            System.out.println(res);
        }
    }
}
