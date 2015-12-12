import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by AhmedAmr on 10/18/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        String[] line = in.readLine().split(" ");
        while(!line[0].equals("0")){
            String temp =line[1].replaceAll(line[0],"");
            if(temp.isEmpty()){
                System.out.println("0");
            }else {
                System.out.println(new BigInteger(temp));
            }
            line = in.readLine().split(" ");
        }
    }
}
