import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by AhmedAmr on 9/19/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = in.readLine();
        ArrayList<Integer> list;
        Stack<Integer> stack;
        while(line != null){
            stack = readInts(line);
            ArrayList<Integer> l = new ArrayList<>();
            list = getFlips(stack, 0, l);
            out.append(line);
            out.append("\n");
            out.append(String.valueOf(list.get(0)));
            list.remove(0);
            for (Integer integer : list) {
                out.append(" ");
                out.append(String.valueOf(integer));
            }
            out.append("\n");
            out.flush();
            line = in.readLine();
        }

    }

    public static ArrayList<Integer> getFlips(Stack<Integer> s , int depth,ArrayList<Integer>list){
        if(isSorted(s)) {
            list.add(0);
            return list;
        }
        int result[] = max(s);
        int dep = depth;
        if(isMaxInTop(s, result[0])) {
            flip(s, 1);
            dep++;
            list.add(dep);
            s.remove(0);
        }else {
            flip(s, result[1]);
            list.add(result[1]+dep);
        }
        return  getFlips(s,dep,list);

    }



    public static void flip(Stack<Integer> s ,int index){
        Queue<Integer> q = new LinkedList<>();
        while(s.size()!=index-1){
            q.add(s.pop());
        }
        while(!q.isEmpty()){
            s.add(q.poll());
        }
    }

    public static boolean isMaxInTop(Stack<Integer> s ,int max){
        if(max == s.peek())
            return true;
        return false;
    }

    public static int[] max(Stack<Integer>s){
        int max = Integer.MIN_VALUE;
        int index = -1;
        int  i = -1;
        for (Integer integer : s) {
            i++;
            if(integer>max){ max= integer;
                index = i;
            }
        }
        int[] arr = {max,index+1};
        return arr;

    }

    public static boolean isSorted(Stack<Integer>s){
        if(s.isEmpty()) return true;
        Stack<Integer> temp = (Stack<Integer>) s.clone();
        while(temp.size()>1){
            int i = temp.pop();
            int j = temp.peek();
            if(i>j) return false;
        }
        return true;
    }

    public static Stack<Integer> readInts(String line){
        String[] arr =  line.split(" ");
//        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer>res = new Stack<>();
        int size = arr.length-1;
        for (int i = size ; i>-1 ; i--) {
            String s = arr[i];
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

}
