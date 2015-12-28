import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/28/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(in.ready()) {
            ArrayList<String> line = readStrings(nextLine(in));
            char[] s1 = line.get(0).toCharArray();
            char[] s2 = line.get(1).toCharArray();
            int size1 = s1.length;
            int size2 = s2.length;
            int current=0;
            for (int i = 0; i < size2; i++) {
                if(current==size1)
                {
                    break;
                }
                if(s1[current]==s2[i]){
                    current++;
                }
            }
            if(current==size1){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }

    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextReadyLine(BufferedReader in) throws IOException {
        if (!in.ready()) return null;
        String line = in.readLine();
        while (line.isEmpty()) {
            if (!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
