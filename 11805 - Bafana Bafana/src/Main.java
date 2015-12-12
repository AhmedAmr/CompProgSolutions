import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/4/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String [] line = in.readLine().split(" ");
            int res = (Integer.parseInt(line[1])+Integer.parseInt(line[2]))%Integer.parseInt(line[0]);
            out.append("Case ");
            out.append(String.valueOf((i+1)));
            out.append(": ");
            if(res==0)out.append(line[0]);
            else out.append(String.valueOf(res));
            out.append("\n");
            out.flush();
        }

    }
}
