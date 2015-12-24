import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 12/24/15.
 */
public class Main {
    static ArrayList<Integer>lengths;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in)); // not needed
        int n = line.get(0); // size of lenghts array
        lengths = readInts(nextLine(in));
        int k = readInts(nextLine(in)).get(0); // not needed
        ArrayList<Integer>qs= readInts(nextLine(in));
        PrintWriter out = new PrintWriter(System.out);
        for (Integer q : qs) {
            int index =  solve(0,n-1,q);
            int min = getMin(index,q);
            int max = getMax(index,q,n);
            if(min==-1){
                out.append("X");
            }else{
                out.append(String.valueOf(min));
            }
            out.append(" ");
            if(max==-1){
                out.append("X");
            }else{
                out.append(String.valueOf(max));
            }
            out.append("\n");
        }
        out.flush();;

    }
    public static int getMin(int start,int value){
        int result = -1;
        for (int i = start; i>=0 ; i--) {
            if(lengths.get(i)<value){
                result =lengths.get(i);
                break;
            }
        }
        return result;

    }

    public static int getMax(int start,int value,int size){
        int result = -1;
        for (int i = start; i <size ; i++) {
            if(lengths.get(i)>value){
                result = lengths.get(i);
                break;
            }
        }
        return result;
    }

    public static int solve(int start , int end,int value){
        if(end-start==1){
            if(value>end)return end;
            return start;
        }
        //get Mid
        int mid = (int)Math.floor((start+end*1.0)/2);
        if(lengths.get(mid)>value){
            return solve(start,mid,value);
        }else{
            return solve(mid,end,value);
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


    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
