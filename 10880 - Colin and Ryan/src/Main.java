import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr =  in.readLine().split(" ");
            Long r = Long.parseLong(arr[1]);
            Long l = Long.parseLong(arr[0]) - r;
            out.append("Case #");
            out.append(String.valueOf(i+1));
            out.append(":");
            if(l == 0){
                out.append(" 0");
            }else {
                SortedSet<Long> list = sortedFactorizeAboveK(l, r);
                int size = list.size();
                if(size>0)
                    out.append(" ");
                int counter = 0;
                for (Long aLong : list) {
                    out.append(String.valueOf(aLong));
                    if (counter < size - 1)
                        out.append(" ");
                    counter++;
                }
            }
            out.append("\n");
            out.flush();
        }
        out.close();

    }
    public static SortedSet<Long> sortedFactorizeAboveK(Long number , Long k ){
        SortedSet<Long> set = new TreeSet<>();
        int step = 1;
        if(number%2 != 0) step=2;
        int size = (int) Math.sqrt(number.doubleValue() + 1);
        for (int i = 1; i <=size ; i+=step) {
            if(number%i == 0){
                Long l = number/i;
                if(l > k)
                    set.add(l);
                if(i > k )
                    set.add((long)i);
            }
        }
        return set;
    }
}
