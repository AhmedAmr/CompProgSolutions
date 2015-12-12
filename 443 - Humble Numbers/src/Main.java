import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by AhmedAmr on 10/29/15.
 */
public class Main {
    static int[] primes = {2,3,5,7};
    static int[] mem = new int[5843];
    static int last = 0;
    static int power = 1;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            int n = Integer.parseInt(line.get(0));
            
            if(last>n) System.out.println();

            line = readStrings(in.readLine());
        }
    }
    
    public static int run(int n){
        int count =0 ;
        if(last>n)return mem[n];

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
