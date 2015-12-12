import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer> list = new ArrayList<>();
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            list.clear();
            int l = Integer.parseInt(in.readLine());
            while(l!=0){
                list.add(l);
                l = Integer.parseInt(in.readLine());
            }
            Collections.sort(list);
            long result = 0;
            int size = list.size();
            int k = size;
            for (Integer integer : list) {
                result+=Math.pow(integer,k);
                if(result>5000000)
                    break;
                k--;
            }

            if(result > 5000000)
                out.append("Too expensive");
            else {
                out.append(String.valueOf(result+result));
            }
            out.append("\n");
            out.flush();
        }
    }

}
