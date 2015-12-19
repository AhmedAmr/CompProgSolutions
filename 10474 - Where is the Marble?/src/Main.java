import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by AhmedAmr on 12/17/15.
 */
public class Main {
    static ArrayList<Integer> list;
    static int MAX;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int c =1 ;
        while(line.get(0)!=0){
            list = new ArrayList<>();
            int n = line.get(0);
            int k = line.get(1);
            for (int i = 0; i < n; i++) {
                list.add(readInts(nextLine(in)).get(0));
            }
            Collections.sort(list);
            MAX = n;
            System.out.println("CASE# " + c + ":");
            c++;
            for (int i = 0; i < k; i++) {
                Integer element = readInts(nextLine(in)).get(0);
                index=-1;
                find(element,0,MAX-1);
                if(index<0){
                    System.out.println(element+" not found");
                }else{
                    System.out.println(element+" found at "+(index+1));
                }
            }
            line = readInts(nextLine(in));
        }
    }

    public static void find(Integer object,int start,int end){
        if(end<start)return;

        //apply binary search
        int mid = (int) Math.floor((start+end)/2);
        int comp = list.get(mid).compareTo(object);
        if(comp<0){
            find(object,mid+1,end);
        }else{
            if(comp==0){
                index = mid;
            }
            find(object,start,mid-1);
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
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
