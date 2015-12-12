import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by AhmedAmr on 9/29/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(in.ready()){
            if(isMetro(readInts(in.readLine()))) {
                out.append(":-) Matrioshka!\n");
            }else{
                out.append(":-( Try again.\n");
            }
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


    public static boolean isMetro(ArrayList<Integer> arr){
        Stack<Node> s = new Stack<>();
        int size = arr.size();
        for (int j = 0; j <size; j++) {
            int i = arr.remove(0);
            if(i>0){
                if(s.isEmpty())return false;
                if(s.peek().value != -1*i) return false;
                s.pop();
                if(j<size-1&&s.isEmpty())return false;
                if(j == size-1) break;
                Node n = s.pop();
                boolean b = n.add(Math.abs(i));
                s.push(n);
                if(!b) return false;
            }else{
                Node n = new Node();
                n.value = i;
                s.push(n);
            }
        }
        return s.isEmpty();
    }

    public static class Node{
        int count=0;
        int value;

        boolean add(int v){
            this.count +=v;
            return this.count < Math.abs(value);
        }
    }



}
