import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by AhmedAmr on 12/28/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0){
            int n = line.get(0);
            int d = line.get(1);
            int r = line.get(2);
            ArrayList<Integer>morning = readInts(nextLine(in));
            ArrayList<Integer>evening = readInts(nextLine(in));
            Collections.sort(morning);
            Collections.sort(evening, Collections.reverseOrder());
            int overTime =0;
            for (int i = 0; i <n; i++) {
                int current = morning.get(i)+evening.get(i);
                if(current>d){
                    overTime+=current-d;
                }
            }
            System.out.println(overTime*r);
            line = readInts(nextLine(in));
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

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
