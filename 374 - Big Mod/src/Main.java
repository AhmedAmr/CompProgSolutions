import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/1/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            ArrayList<String> line = readStrings((in.readLine()));
            int a = Integer.parseInt(line.get(0));
            line = readStrings((in.readLine()));
            int b =Integer.parseInt(line.get(0));
            line = readStrings((in.readLine()));
            int m =Integer.parseInt(line.get(0));
            System.out.println(bigMod(a,b,m));
            if(in.ready())
                in.readLine();
            else break;
        }
    }

    public static int bigMod(int a , int b , int m){
        int a1 = a%m;
        int p=1;
        while(b>0){
            if(b%2!=0){
                p*=a1;
                p=p%m;
            }
            b/=2;
            a1=(a1*a1)%m;
        }
        return p%m;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }


}
