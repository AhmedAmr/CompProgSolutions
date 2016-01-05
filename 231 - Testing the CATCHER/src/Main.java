import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 1/4/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        ArrayList<Integer>list = new ArrayList<>();
        int c = 1;
        while(line.get(0)!=-1){
            while(line.get(0)!=-1){
                list.add(line.get(0));
                line = readInts(nextLine(in));
            }
            Collections.reverse(list);
            int lis = LIS_fast(list);
            System.out.println("Test #"+c+":");
            c++;
            System.out.println("  maximum possible interceptions: "+lis);
            line = readInts(nextLine(in));
            list = new ArrayList<>();
            if(line.get(0)!=-1) System.out.println();
        }
    }

    public static int position_non_dec(ArrayList<Integer>list,int value){
        int start = 0;
        int end = list.size()-1;
        while(start!=end){
            int mid = (int)Math.floor((start+end)/2);
            if(value>=list.get(mid)){
                start=mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public static int LIS_fast(ArrayList<Integer>input){
        ArrayList<Integer>res = new ArrayList<>();
        int last = 0;
        res.add(input.get(0));
        input.remove(0);
        for (Integer integer : input) { // O(n)
            if(integer>=res.get(last)){
                //append it to the result
                res.add(integer);
                last++;
            }else {
                int index = position_non_dec(res,integer); // O(lg n)
                    res.set(index,integer);
            }
        }
        return last+1;
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
