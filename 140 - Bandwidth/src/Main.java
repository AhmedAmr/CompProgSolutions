import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by AhmedAmr on 11/13/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        PrintWriter out = new PrintWriter(System.out);;
        while(!line.get(0).equals("#")){
            HashMap<String,TreeSet<String>> map = new HashMap<>();
            for (String s : line) {
                String[] arr = s.split(":");
                TreeSet<String> set = new TreeSet<>();
                if(map.containsKey(arr[0])){
                    set = map.get(arr[0]);
                }
                char[] ne = arr[1].toCharArray();
                for (char c : ne) {
                    String negh = String.valueOf(c);
                    TreeSet<String> temp =  new TreeSet<>();
                    if(map.containsKey(negh)){
                        temp = map.get(negh);
                    }
                    temp.add(arr[0]);
                    map.put(negh, temp);
                    set.add(negh);
                }
                map.put(arr[0],set);
            }
            ArrayList<ArrayList<String>> per = new ArrayList<>();
            ArrayList<Integer> results = new ArrayList<>();
            int l = map.keySet().size();
            permute(per,l,new ArrayList<>(map.keySet()));
            int minOrder = Integer.MAX_VALUE;
            int i = 0;
            for (ArrayList<String> strings : per) {
                int order = getOrderingBandwidth(strings,map,l);
                if(order<minOrder){
                    minOrder = order;
                    results.clear();
                    results.add(i);
                }else if(order==minOrder)
                {
                    results.add(i);
                }
                i++;
            }
            Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                    Iterator<String> it1 = o1.iterator();
                    Iterator<String> it2 = o2.iterator();
                    while(it1.hasNext()){
                        String v1 = it1.next();
                        String v2 = it2.next();
                        int res = v1.compareTo(v2);
                        if(res == 0)continue;
                        return res;
                    }
                    return 0;
                }
            };
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            for (Integer result : results) {
                list.add(per.get(result));
            }
            ArrayList<String> finalRes = Collections.min(list,comparator);
            for (String finalRe : finalRes) {
                out.append(finalRe+" ");
            }
            out.append("-> ");
            out.append(String.valueOf(minOrder));
            out.append("\n");
            out.flush();
            line = readStrings(nextLine(in));
        }
    }

    public static int getOrderingBandwidth(ArrayList<String> list , HashMap<String,TreeSet<String>> map,int l){
        int max = Integer.MIN_VALUE;
        int k = 0;
        for (String s : list) {
            TreeSet<String> negh = map.get(s);
            for (int i = l-1; i >=0; i--) {
                if(negh.contains(list.get(i))){
                    int temp =Math.abs(k-i);
                    if(temp>max)max = temp;
                    break;
                }
            }
            k++;
        }
        return max;
    }


    public static void permute(ArrayList<ArrayList<String>> res , int n ,ArrayList<String> a){
        if(n==1) res.add(new ArrayList<>(a));
        else{
            for (int i = 0; i < n - 1; i++) {
                permute(res,n-1,a);
                if(n%2==0){
                    swap(a,i,n-1);
                }else{
                    swap(a,0,n-1);
                }
            }
            permute(res,n-1,a);
        }
    }

    public static void swap (ArrayList<String> arr , int i , int j){
        Collections.swap(arr, i, j);
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(";");
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
