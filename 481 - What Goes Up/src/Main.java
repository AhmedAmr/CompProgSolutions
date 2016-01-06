import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by AhmedAmr on 1/5/16.
 */
public class Main {
    static ArrayList<Integer>input = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line ;
        while(true) {
            line = readInts(nextLine(in));
            input.add(line.get(0));
            if(!in.ready())break;
        }

        ArrayList<Integer>result = LIS_fast(new ArrayList<>(input));
        System.out.println(result.size());
        System.out.println("-");
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


    public static ArrayList<Integer> LIS_fast(ArrayList<Integer>inputArr){
        ArrayList<Integer>lis = new ArrayList<>();
        ArrayList<Integer>indeces = new ArrayList<>();
        int[] parents = new int[inputArr.size()];
        lis.add(inputArr.get(0));
        indeces.add(0);
        int last = 0;
        inputArr.remove(0);
        //initialize the parents array with -1
        for (int i = 0; i < input.size(); i++) {
            parents[i]=-1;
        }
        int current=1; // current item index in input
        for (Integer integer : inputArr) { // O(n)

            if(integer>lis.get(last)){
                //append it to the result
                lis.add(integer);
                indeces.add(current);
                parents[current]=indeces.get(last);
                last++;
            }else {
                int index = position_inc(lis,integer); // O(lg n)
                if(index!=-1){
                    lis.set(index,integer);
//                    results.add(new ArrayList<>(res));
                    indeces.set(index,current);
                    if(index-1>-1)
                        parents[current]= indeces.get(index-1);
                }
            }
            current++;
        }
        ArrayList<Integer> results = new ArrayList<>();
        int iter=indeces.get(last);
        while(iter!=-1){
            results.add(input.get(iter));
            iter = parents[iter];
        }
        Collections.reverse(results);
        return results;

    }


    public static int position_inc(ArrayList<Integer>list,int value){
        int start = 0;
        int end = list.size()-1;
        while(start!=end){
            int mid = (int)Math.floor((start+end)/2);
            if(value==list.get(mid))return -1;
            if(value>list.get(mid)){
                start=mid+1;
            }else{
                end = mid;
            }
        }
        return start;
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
