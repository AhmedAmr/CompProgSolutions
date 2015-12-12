import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 9/10/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String l = nextLine(in);
        while(l!=null){
            int size = readInts(l).get(0);
            Long[] arr = new Long[size];
            String[] line = nextLine(in).split(" ");
            int lineSize = line.length;
            int k = 0;
            for (int j = 0; j < lineSize; j++) {
                if(!line[j].isEmpty()) {
                    arr[k] = Long.parseLong(line[j]);
                    k++;
                }
                if(k>=size)
                    break;
            }
            out.append("Minimum exchange operations : ");
            out.append(String.valueOf(bubbleSortSwaps(arr)));
            out.append("\n");
            out.flush();
            l = nextLine(in);
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


    public static String nextLine(BufferedReader in) throws IOException {
        if(!in.ready()) return null;
        String line = in.readLine();
        while(line.isEmpty()) {
            if(!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static int bubbleSortSwaps(Long[] arr){
        int swaps=0;
        int k = 0;
        int minIdx = getMinIndex(arr,k);
        while(minIdx!=-1){
            for (int i = minIdx; i > k; i--) {
                swap(arr,i,i-1);
                swaps++;
            }
            k++;
            minIdx = getMinIndex(arr,k);
        }
        return swaps;
    }
    public static int getMinIndex(Long[] arr,int start){
        Long min = Long.MAX_VALUE;
        int index = -1;
        int size =arr.length;
        if(arr == null || size==0)
            return -1;

        for (int i = start; i < size; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;

            }
        }

        return index;
    }
    private static void swap (Comparable[] arr , int i , int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

