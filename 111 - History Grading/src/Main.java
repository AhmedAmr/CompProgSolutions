import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by AhmedAmr on 12/31/15.
 */
public class Main {
    static int MAX ;
    static ArrayList<Integer>answer ;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        MAX = line.get(0);
        answer = trasform(readInts(nextLine(in)));
        while(in.ready()){
            line = trasform(readInts(nextLine(in)));
            System.out.println(LIS_fast(line));
        }
    }
    public static ArrayList<Integer>trasform(ArrayList<Integer>list){
        ArrayList<Integer> res = new ArrayList<>();
        //initilize
        for (int i = 0; i < MAX; i++) {
            res.add(0);
        }
        int k = 1;
        for (Integer item : list) {
            res.set(item-1,k);
            k++;
        }
        return res;
    }


    public static int getPos(int event){
        int index = -1;
        int i =0;
        for (Integer integer : answer) {
            if(event==integer){
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    public static int position_fast(ArrayList<Integer>list,int value){
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


    public static int LIS_fast(ArrayList<Integer>input){
        ArrayList<Integer>res = new ArrayList<>();
        int last = 0;
        res.add(getPos(input.get(0)));
        input.remove(0);
        for (Integer integer : input) { // O(n)
            if(getPos(integer)>res.get(last)){
                //append it to the result
                res.add(getPos(integer));
                last++;
            }else {
                int index = position_fast(res,getPos(integer)); // O(lg n)
                if(index!=-1){
                    res.set(index,getPos(integer));
                }
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
