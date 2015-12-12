import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by AhmedAmr on 11/16/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        while(line.get(0)!=0){
            int n = line.get(0);
            int m = line.get(1);
            if(m!=0) {
                ArrayList<Integer> seats = new ArrayList<>();
                ArrayList<ArrayList<Integer>> perm = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    seats.add(i);
                }
                permute(perm, n, seats);
                for (int i = 0; i < m; i++) {
                    line = readInts(nextLine(in));
                    solve(perm, line.get(0), line.get(1), line.get(2).intValue());

                }
                System.out.println(perm.size());
            }else{
                System.out.println(fact(n));
            }
            line = readInts(nextLine(in));
        }
    }

    public static int fact(int n){
        int res = 1;
        for (int i = n; i >1 ; i--) {
            res*=i;
        }
        return res;
    }

    public static void solve(ArrayList<ArrayList<Integer>> list , Integer i , Integer j,int c){
        for (Iterator<ArrayList<Integer>> iterator = list.iterator(); iterator.hasNext(); ) {
            ArrayList<Integer> next =  iterator.next();
            int diff = Math.abs(next.indexOf(i)-next.indexOf(j));
            if(c<0&&diff<Math.abs(c)){
                iterator.remove();
            }else if(c>0 && diff>c){
                iterator.remove();
            }
        }
    }

    public static void permute(ArrayList<ArrayList<Integer>> res , int n ,ArrayList<Integer> a){
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

    public static void swap (ArrayList<Integer> arr , int i , int j){
        Collections.swap(arr, i, j);
    }


    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
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
