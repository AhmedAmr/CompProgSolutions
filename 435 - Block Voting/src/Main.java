import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by AhmedAmr on 11/4/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int l = line.get(0);
        for (int i = 0; i <l; i++) {
            line = readInts(nextLine(in));
            int k = line.get(0);
            line.remove(0);
            ArrayList<ArrayList<Integer>> perms = permute(k-1);
            int half= 0;
            for (Integer integer : line) {
                half+=integer;
            }
            half = (int)Math.ceil(half*1.0/2);
            int c = 1;
            for (Integer integer : line) {
               ArrayList<Integer> parties = new ArrayList<>(line);
                parties.remove(integer);
                int powerInd = powerIndex(perms,integer,parties,half);
                System.out.println("party "+c+" has power index "+powerInd);
                c++;
            }
            System.out.println();
        }
    }

    public static int powerIndex( ArrayList<ArrayList<Integer>> perms,int party,ArrayList<Integer> parties,int half){
        ArrayList<Integer> summations = new ArrayList<>();
        for (ArrayList<Integer> perm : perms) {
            int sum = 0;
            for (Integer integer : perm) {
                sum+=parties.get(integer);
            }
            summations.add(sum);
        }
        int res = 0;
        for (Integer summation : summations) {
            if(summation<half){
                if(summation+party>=half)res++;
            }
        }
        return res;
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }


    public static ArrayList<ArrayList<Integer>> permute(int k){
        int end = 1<<(k);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i <end; i++) {
            res.add(getOnes(i));
        }
        return res;
    }

    public static ArrayList<Integer> getOnes(int n) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(n!=0) {
            int temp = 1 & n;
            if (temp == 1) {
                list.add(i);
            }
            i++;
            n>>=1;
        }
        return list;
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
