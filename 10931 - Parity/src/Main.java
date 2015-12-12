import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/29/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings((in.readLine()));
        while(!line.get(0).equals("0")){
            String l = Integer.toString(Integer.parseInt(line.get(0)),2);
            char[] arr = l.toCharArray();
            int count=0;
            for (char c : arr) {
                if(c=='1')count++;
            }
            System.out.println("The parity of "+l+" is "+count+" (mod 2).");
            line = readStrings((in.readLine()));
        }

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
