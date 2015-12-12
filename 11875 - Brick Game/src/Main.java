import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 10/4/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String [] arr = in.readLine().split(" ");
            int size = Integer.parseInt(arr[0]);
            list.clear();
            for (int j = 1; j < size+1; j++) {
                list.add(Integer.parseInt(arr[j]));
            }
            Collections.sort(list);
            out.append("Case ");
            out.append(String.valueOf((i+1)));
            out.append(": ");
            out.append(String.valueOf(list.get((size/2))));
            out.append("\n");
            out.flush();
        }
    }
}
