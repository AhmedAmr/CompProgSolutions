import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by AhmedAmr on 12/28/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int set = 1;
        while(in.ready()){
            ArrayList<Integer> line = readInts(nextLine(in));
            int c = line.get(0);
            int s = line.get(1);
            line = readInts(nextLine(in));
            int diff = 2*c-s;
            for (int i = 0; i <diff; i++) {
                //dummy node
                line.add(0);
            }
            ArrayList<ArrayList<Integer>>res = new ArrayList<>();
            ArrayList<Integer>input = new ArrayList<>(line);
            diff+=s;

            Collections.sort(line);
            for (int i = 0; i <c; i++) {
                ArrayList<Integer>list = new ArrayList<>();
                if(line.get(i)!=0){
                    list.add(line.get(i));
                }
                if(line.get(diff-i-1)!=0){
                    list.add(line.get(diff-i-1));
                }
                if(list.isEmpty())list.add(0);
                res.add(list);
            }
            print(res,input,imbalance(res, avg(line, c)),set,c);
            set++;
        }
    }


    public static void print(ArrayList<ArrayList<Integer>>res ,ArrayList<Integer>input,double impl,int set,int c){
        System.out.println("Set #"+set);
        int current = 0;
        for (int i = 0; i < c; i++) {
            System.out.print(" "+i+":");
            ArrayList<Integer>list = getlist(res,input.get(current));
            while(list==null){
                current++;
                list = getlist(res,input.get(current));
            }
            for (Integer integer : list) {
                if(integer!=0)
                System.out.print(" " + integer);
            }
            System.out.println();
        }
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println("IMBALANCE = "+df.format(impl));
        System.out.println();
    }
    public static ArrayList<Integer> getlist(ArrayList<ArrayList<Integer>>res,Integer item){
        ArrayList<Integer>r = new ArrayList<>();
        for (ArrayList<Integer> re : res) {
            if(re.contains(item)){
                r = re;
                break;
            }
        }
        if(r.isEmpty())
            return null;
        r.remove(item);
        r.add(0, item);
        res.remove(r);
        return r;
    }

    public static double imbalance(ArrayList<ArrayList<Integer>>res,double avg){
        double imbalance = 0;
        for (ArrayList<Integer> re : res) {
            int sum = 0;
            for (Integer integer : re) {
                sum+=integer;
            }
            imbalance+=Math.abs(sum-avg);
        }
        return imbalance;
    }

    public static double avg(ArrayList<Integer>list,int c){
        double total=0;
        for (Integer integer : list) {
            total+=integer;
        }
        return total/c;
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
