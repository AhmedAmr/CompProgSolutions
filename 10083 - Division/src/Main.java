import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/18/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        while(line!=null){
            BigInteger t = new BigInteger(line.get(0));
            int a = Integer.parseInt(line.get(1));
            int b = Integer.parseInt(line.get(2));
            System.out.print("("+line.get(0)+"^"+line.get(1)+"-1)/("+line.get(0)+"^"+line.get(2)+"-1) ");
            if(a<b){
                System.out.print("is not an integer with less than 100 digits.\n");
            }else if (a==b){
                System.out.print("1\n");
            }else{

                if(a-b>500
                        ){
                    System.out.print("is not an integer with less than 100 digits.\n");
                }else{
                    BigInteger up = t.pow(a).subtract(BigInteger.ONE);
                    BigInteger down  = t.pow(b).subtract(BigInteger.ONE);
                    if(up.mod(down).equals(BigInteger.ZERO)){
                        BigInteger res  = up.divide(down);
                        if(res.toString().length()>100){
                            System.out.print("is not an integer with less than 100 digits.\n");
                        }else{
                            System.out.print(res+"\n");
                        }
                    }else{
                        System.out.print("is not an integer with less than 100 digits.\n");
                    }
                }
            }
            line = readStrings(nextLine(in));
        }

    }

    public static ArrayList<String> readStrings(String line) {
        if(line == null) return null;
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        if (!in.ready()) return null;
        String line = in.readLine();
        while (line.isEmpty()) {
            if (!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

}

