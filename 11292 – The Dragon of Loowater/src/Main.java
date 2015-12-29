import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by AhmedAmr on 12/29/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0) {
            int n = line.get(0);
            int m = line.get(1);
            ArrayList<Integer> lengths = new ArrayList<>();
            ArrayList<Integer> heads = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                heads.add(readInts(nextLine(in)).get(0));
            }
            for (int i = 0; i < m; i++) {
                lengths.add(readInts(nextLine(in)).get(0));
            }
            Collections.sort(lengths);
            Collections.sort(heads);
            int coins = 0;
            int headsRemaining=n;
            Iterator<Integer>currentHead = heads.iterator();
            Iterator<Integer>currentKnight = lengths.iterator();
            int head = currentHead.next();
            while(currentKnight.hasNext()){
                int knight = currentKnight.next();
                if(head>knight)continue;
                else{
                    coins+=knight;
                    headsRemaining--;
                    if(!currentHead.hasNext())break;
                    head = currentHead.next();
                }
            }
            if(headsRemaining==0){
                System.out.println(coins);
            }else{
                System.out.println("Loowater is doomed!");
            }
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
