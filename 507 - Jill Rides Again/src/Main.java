import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 1/14/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int n = line.get(0);
        for (int i = 1; i <= n; i++) {
            line = readInts(nextLine(in));
            int m = line.get(0);
            int[] a = new int[m-1];
            for (int j = 0; j < m-1 ; j++) {
                a[j] = readInts(nextLine(in)).get(0);
            }
            MaxSumNode result = getMaxSum(a,m-1);
            if(result.max>0){
                System.out.println("The nicest part of route "+i+" is between stops "+(result.start+1)+" and "+(result.end+2));
            }else{
                System.out.println("Route "+i+" has no nice parts");
            }
        }
    }

   public static MaxSumNode getMaxSum(int a[],int size){
       MaxSumNode result = new MaxSumNode();
       int currentMax=0;
       int currentStart=0;
       for (int currentEnd = 0; currentEnd < size; currentEnd++) {
           currentMax+=a[currentEnd];

           if(currentMax>=result.max){
               if((currentMax == result.max)&&(result.end-result.start)<(currentEnd-currentStart))
                    result = new MaxSumNode(currentMax,currentStart,currentEnd);
               else if(currentMax>result.max){
                   result = new MaxSumNode(currentMax,currentStart,currentEnd);
               }
           }

           if(currentMax<0){
               currentMax=0;
               currentStart=currentEnd+1;
           }
       }
        return result;
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
class MaxSumNode
{

    public MaxSumNode() {
    }

    public MaxSumNode(int max, int start, int end) {
        this.max = max;
        this.start = start;
        this.end = end;
    }

    int max=Integer.MIN_VALUE;
    int start = 0;
    int end = 0;

}

