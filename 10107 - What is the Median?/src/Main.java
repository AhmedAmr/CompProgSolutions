import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<Integer> list =  new ArrayList<>();
        int size = 0;
        while(in.ready()){
            size++;
            int num = Integer.parseInt(in.readLine().replace(" ",""));
            list.add(num);
            out.append(String.valueOf(medianInt(list, size)));
            out.append("\n");
            out.flush();
        }
    }

    /*
     Median truncated to int
      */
    public static long medianInt(ArrayList<Integer> list , int size){
        Collections.sort(list);
        if(size%2==0){
            int pos = size/2;
            long res = (long)list.get(pos-1)+(long)list.get(pos);
            return (long)Math.floor(res/2);
        }else{
            //odd
            return list.get((size+1)/2-1);
        }
    }
    public static long medianInt(ArrayList<Integer> list ) {
        return medianInt(list,list.size());
    }

}
