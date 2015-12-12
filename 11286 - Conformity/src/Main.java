import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 10/1/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
        int n = Integer.parseInt(in.readLine());
        while(n!=0){
            map.clear();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> set = readInts(in.readLine());
                if(map.containsKey(set)){
                    map.put(set,map.get(set)+1);
                }else{
                    map.put(set,1);
                }
            }
            ArrayList<Integer>list = new ArrayList<>(map.values());
            out.append(String.valueOf(collect(list)));
            out.append("\n");
            out.flush();
            n = Integer.parseInt(in.readLine());
        }

    }

    public static int collect(ArrayList<Integer> c){
        Collections.sort(c,Collections.reverseOrder());
        int v = c.remove(0);
        int res = v;
        for (Integer integer : c) {
            if (integer == v) res+=v;
            else break;
        }
        return res;
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        Collections.sort(res);
        return res;
    }


}
