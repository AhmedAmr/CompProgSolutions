import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        ArrayList<GameNumber> list  = new ArrayList<>();
        while(n!=0){
            list.clear();
            String[] data = in.readLine().split(" ");
            for (String s : data) {
                list.add(m.new GameNumber(s));
            }
            Collections.sort(list);

            for (GameNumber g : list) {
                out.append(g.number);
            }
            out.append("\n");
            out.flush();
            n = Integer.parseInt(in.readLine());
        }
        out.close();
    }

    class GameNumber implements Comparable<GameNumber>{
        String number;

        public GameNumber(String number){
            this.number = number;
        }


        @Override
        public int compareTo(GameNumber o) {
            BigInteger i1 = new BigInteger(this.number + o.number);
            BigInteger i2 = new BigInteger(o.number + this.number);
            if(i1.compareTo(i2) > 0){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
