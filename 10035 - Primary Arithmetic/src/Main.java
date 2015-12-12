import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 10/7/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line[] = in.readLine().split(" ");
        int n1 = Integer.parseInt(line[0]);
        int n2 = Integer.parseInt(line[1]);
        while(!(n1==0 && n2==0)){
            int carry = 0;
            int res = 0;
            while(!(n1==0 && n2==0)){
                int temp1 = n1%10;
                int temp2 = n2%10;
                n1 = n1/10;
                n2 = n2/10;
                carry = (carry+temp1+temp2)/10;
                if(carry>0)
                    res++;
            }
            if(res == 0){
                out.append("No carry operation.\n");
            }else if(res == 1){
                out.append("1 carry operation.\n");
            }
            else {
                out.append(String.valueOf(res));
                out.append(" carry operations.\n");
            }
            out.flush();
            line = in.readLine().split(" ");
            n1 = Integer.parseInt(line[0]);
            n2 = Integer.parseInt(line[1]);
        }

    }
}
