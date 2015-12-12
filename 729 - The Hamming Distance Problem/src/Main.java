import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by AhmedAmr on 11/19/15.
 */
public class Main {
    static ArrayList<Integer[]> res  = new ArrayList<>();
    static Integer[] current ;
    static int MAX ;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=  new PrintWriter(System.out);
        ArrayList<Integer> line = readInts(nextLine(in));
        int l = line.get(0);
        for (int i = 0; i < l; i++) {
            res = new ArrayList<>();
            line = readInts(nextLine(in));
            current = new Integer[line.get(0)];
            MAX = line.get(0);
            for (int j = 0; j <MAX ; j++) {
                current[j] = 0;
            }
            solve(0, line.get(1));
            print(res,out);
            if(i<l-1) System.out.println();
        }
    }

    public static void solve(int i , int rem)
    {
        // prune the tree at rem==0
        if(rem==0){
            res.add(Arrays.copyOf(current,MAX));
            return;
        }
        //invalid case
        if(i==MAX){
            return;
        }

        for (int j = 0; j < 2; j++) {
            //do
            current[i] = j;

            // recurse
            solve(i+1,rem-j);

            //undo
            current[i]=0;
        }
        return;
    }
    private static void print(ArrayList<Integer[]> result, PrintWriter out) {
        for (Integer[] strings : result) {
            for (Integer string : strings) {
                out.append(String.valueOf(string));
            }
            out.append("\n");
        }
        out.flush();
    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static void permute(ArrayList<ArrayList<String>> res , int n ,ArrayList<String> a){
        if(n==1) res.add(new ArrayList<>(a));
        else{
            for (int i = 0; i < n - 1; i++) {
                permute(res,n-1,a);
                if(n%2==0){
                    swap(a,i,n-1);
                }else{
                    swap(a,0,n-1);
                }
            }
            permute(res,n-1,a);
        }
    }


    public static void swap (ArrayList<String> arr , int i , int j){
        Collections.swap(arr, i, j);
    }


    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
