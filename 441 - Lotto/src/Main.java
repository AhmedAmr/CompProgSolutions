import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 11/11/15.
 */
public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<String> line = readStrings(nextLine(in));
        while(true){
            ArrayList<Result> results = new ArrayList<>();
            int k = Integer.parseInt(line.get(0));
            line.remove(0);
            ArrayList<Integer> input = getInts(line);
            int end = 1<<k;
            int start = 1<<5;

            for (int i = start; i <end; i++) {
                ArrayList<Integer> list = getOnes(i);
                if(list.size()==6){
                    SortedSet<Integer> res = new TreeSet<>();
                    for (Integer integer : list) {
                        res.add(input.get(integer));
                    }
                   results.add(new Result(res));
                }
            }
            Collections.sort(results);
            for (Result result : results) {
                print(result.set,out);
            }
            line = readStrings(nextLine(in));
            if(!line.get(0).equals("0")) System.out.println();
            else break;
        }

    }

    public static ArrayList<Integer> getInts(ArrayList<String>list)
    {
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : list) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static ArrayList<Integer> getOnes(int n) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(n!=0) {
            int temp = 1 & n;
            if (temp == 1) {
                list.add(i);
            }
            i++;
            n>>=1;
        }
        return list;
    }

    public static void print(SortedSet<Integer> set,PrintWriter out){
        Integer first = set.first();
        out.append(String.valueOf(first));
        set.remove(first);
        for (Integer integer : set) {
            out.append(" "+String.valueOf(integer));
        }
        out.append("\n");
        out.flush();
        set.add(first);
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
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
class Result implements Comparable<Result> {
    SortedSet<Integer> set;

    public Result(SortedSet<Integer> set) {
        this.set = set;
    }

    @Override
    public int compareTo(Result o) {
        Iterator<Integer> it1 = this.set.iterator();
        Iterator<Integer> it2 = o.set.iterator();
        int thisElement;
        int oElement;
        while (it1.hasNext()) {
            thisElement = it1.next();
            oElement = it2.next();
            if (thisElement > oElement) return 1;
            if (thisElement < oElement) return -1;
        }
        return 0;
    }
}

