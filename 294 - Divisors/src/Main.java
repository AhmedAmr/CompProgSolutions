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
        ArrayList<String> line = readStrings((in.readLine()));
        int l = Integer.parseInt(line.get(0));
        for (int i = 0; i < l; i++) {
            line = readStrings(in.readLine());
            int start = Integer.parseInt(line.get(0));
            int end = Integer.parseInt(line.get(1));
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int j = start  ; j <=end ; j++) {
                int res = factorsSize(new Long(j));
                if(res>max){
                    index=j;
                    max=res;
                }
            }
            System.out.println("Between "+start+" and "+end+", "+index+" has a maximum of "+max+" divisors.");
        }
    }


    public static int factorsSize(Long number){
        int step = 1;
        if(number%2 != 0) step=2;
        ArrayList<Long>list = new ArrayList<>();
        int size = (int) Math.sqrt(number.doubleValue() + 1);
        for (int i = 1; i <=size ; i+=step) {
            if(number%i == 0){
                long a = number/i;
                if(!list.contains(a))list.add(a);
                long b = i;
                if(!list.contains(b))list.add(b);
            }
        }
        return list.size();
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
