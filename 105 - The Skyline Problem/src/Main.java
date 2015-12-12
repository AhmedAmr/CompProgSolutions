import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/9/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
            int[] hights = new int[10001];
            while(true) {
                int start = Integer.parseInt(line.get(0));
                int end = Integer.parseInt(line.get(2));
                int h = Integer.parseInt(line.get(1));
                for (int i = start; i < end; i++) {
                    if (h > hights[i]) hights[i] = h;
                }

                if (!in.ready()) break;
                line = readStrings(nextLine(in));
            }
            ArrayList<Integer> res = new ArrayList<>();
            int current = -1;
            for (int i = 1; i < 10001; i++) {
                if (hights[i] != current) {
                    current = hights[i];
                    res.add(i);
                    res.add(current);
                }
            }
        System.out.print(res.get(0));
        res.remove(0);
        for (Integer re : res) {
            System.out.print(" " + re);
        }
        System.out.println();
        }


    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
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
