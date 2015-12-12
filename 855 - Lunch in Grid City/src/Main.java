import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> streets = new ArrayList<>();
        ArrayList<Integer> aven = new ArrayList<>();

        int n = readInts(nextLine(in)).get(0);
        for (int i = 0; i < n; i++) {
            streets.clear();
            aven.clear();
            int f = readInts(nextLine(in)).get(2);
            for (int j = 0; j < f; j++) {
                ArrayList<Integer> l = readInts(nextLine(in));
                streets.add(l.get(0));
                aven.add(l.get(1));
            }
            int x = median(streets, f);
            int y = median(aven, f);
            System.out.println("(Street: "+x+", Avenue: "+y+")");
        }
    }


    public static int median(ArrayList<Integer> list,int size){
        if(size == 0)
            return 0;
        Collections.sort(list);
        return list.get((int)Math.floor((size-1)/2));
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }
    public static String nextLine(BufferedReader in) throws IOException {
        if(!in.ready()) return null;
        String line = in.readLine();
        while(line.isEmpty()) {
            if(!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }


}
