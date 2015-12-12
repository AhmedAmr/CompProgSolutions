import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/7/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (in.ready()) {
            ArrayList<Integer> input =readInts(in.readLine());
            int [] arr =new int[2];
            arr[0] = input.get(0);
            arr[1] = input.get(1);
            ArrayList<Integer> list = new ArrayList<>();
            getFraction(arr,list);
            out.append("[");
            out.append(String.valueOf(list.get(0)));
            int size = list.size();
            for (int i = 1; i < size; i++) {
                if(i==1){
                    out.append(";");
                }else{
                    out.append(",");
                }
                out.append(String.valueOf(list.get(i)));
            }
            out.append("]\n");
            out.flush();
        }

    }

    public static ArrayList<Integer> readInts(String line){
        String[] arr =  line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if(!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static void getFraction(int[]arr , ArrayList<Integer> list){
        if(arr[0]==0||arr[1]==0){
            return;
        }
        int res = arr[0]/arr[1];
        arr[0] = arr[0]%arr[1];
        swap(arr);
        list.add(res);
        getFraction(arr,list);
    }
    public static void swap(int[]arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}
