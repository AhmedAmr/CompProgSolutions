import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by AhmedAmr on 9/18/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line[] = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        while(n!=0){
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i+1]);
            }
            long result = getInversionIndex(arr,0,arr.length-1).inversionIndx;
            if(result%2!=0){
                out.append("Marcelo\n");
            }else{
                out.append("Carlos\n");
            }
            out.flush();
            line = in.readLine().split(" ");
            n = Integer.parseInt(line[0]);
        }
    }

    public static InversionNode getInversionIndex(Comparable[] arr,int start,int end){
        //Divide
        if(start>=end){
            return new InversionNode(new Comparable[]{arr[start]},0) ;
        }
        int center = (end+start)/2;
        InversionNode left = getInversionIndex(arr, start, center);
        InversionNode right = getInversionIndex(arr,center+1,end);
        //Conquer
        int i = 0;
        int j = 0;
        int current=0;
        int leftSize = left.arr.length;
        int rightSize = right.arr.length;
        InversionNode res = new InversionNode(new Comparable[leftSize+rightSize],left.inversionIndx+right.inversionIndx);
        while(i<leftSize && j<rightSize){
            if(left.arr[i].compareTo(right.arr[j])<=0){
                res.arr[current] = left.arr[i];
                i++;
            }else{
                res.inversionIndx+=(leftSize-i);
                res.arr[current] = right.arr[j];
                j++;
            }
            current++;
        }
        while(i<leftSize){
            res.arr[current] = left.arr[i];
            current++;
            i++;
        }
        while(j<rightSize){
            res.arr[current] = right.arr[j];
            current++;
            j++;
        }
        return res;
    }


    public static class InversionNode{
        Comparable[] arr;
        long inversionIndx=0;

        public InversionNode(Comparable[] arr,long inversionIndx){
            this.arr = arr;
            this.inversionIndx = inversionIndx;
        }
    }
}
