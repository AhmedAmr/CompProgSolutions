import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by AhmedAmr on 11/16/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        int n = line.get(0);
        for (int i = 0; i < n; i++) {
            int p = readInts(nextLine(in)).get(0);
            int k = readInts(nextLine(in)).get(0);
            ArrayList<Integer> leds = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                String string = in.readLine().replace(" ","");
                leds.add(Integer.valueOf(string,2));
            }
            System.out.println(solve(leds,p));
        }
    }

    public static int solve(ArrayList<Integer> leds, int l){
        ArrayList<ArrayList<Integer>> perm = permuteAllSets(l);
        Comparator<ArrayList<Integer>> comparator  = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()<o2.size()) return 1;
                if(o2.size()<o1.size()) return -1;
                return 0;
            }
        };
        Collections.sort(perm,comparator);
            for (ArrayList<Integer> integers : perm) {
             int mask = getMask(integers,l);
                ArrayList<Integer> list = new ArrayList<>();
                for (Integer led : leds) {
                    int res = mask&led;
                    if(!list.contains(res)){
                        list.add(res);
                    }else{
                        break;
                    }
                }
                if(list.size() == leds.size())return l-integers.size();
        }
        return l;
    }
    
    public static int getMask(ArrayList<Integer>list,int l){
        int res  = (1<<(l+1))-1;
        for (Integer integer : list) {
            res-=Math.pow(2,integer);
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> permuteAllSets(int k){
        int end = 1<<(k);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <end; i++) {
            res.add(getOnes(i));
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
