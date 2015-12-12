import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Created by AhmedAmr on 9/7/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {



        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = in.readLine();
        long start = System.currentTimeMillis();
        HashMap<String , String> map = new HashMap<>();
        HashMap<String , Integer> rep = new HashMap<>();
        TreeSet<String> stop = new TreeSet<>();
        while(!line.equals("::")){
            stop.add(line);
            line = in.readLine();
        }

        while(in.ready()){
            String s = in.readLine().toLowerCase();
            ArrayList<Node> list = getDetails(s);
            for(Node node:list) {
                String string = node.keyword;
                if (!stop.contains(string)) {
                    String l = node.keyword.toUpperCase();
                    String newString = replace(s,node);
                    if (rep.containsKey(l)) {
                        int value = rep.get(l);
                        value++;
                        map.put((l + value), newString);
                        rep.put(l, value);
                    } else {
                        map.put(l, newString);
                        rep.put(l, 0);
                    }
                }
            }
        }
        ArrayList<String> results = new ArrayList<>(map.keySet());
        Collections.sort(results);
        for (String result : results) {
            out.append(map.get(result));
            out.append("\n");
            out.flush();

        }
        System.out.println((System.currentTimeMillis()-start)*1.0/1000);
    out.close();
    }


    public static String replace(String s , Node n){
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.replace(n.startIndex,n.endIndex,n.keyword.toUpperCase());
        return stringBuilder.toString();
    }

    public static ArrayList<Node> getDetails(String s){
        ArrayList<Node> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        int size = arr.length;
        Node n = new Node();
        boolean isRunning = false;
        for (int i = 0; i <size; i++) {
            if(arr[i] == ' '){
                if(isRunning){
                    n.endIndex = i;
                    n.keyword = s.substring(n.startIndex,n.endIndex);
                    list.add(n);
                    n = new Node();
                    isRunning = false;
                }
            }else{
                if(!isRunning){
                    isRunning = true;
                    n.startIndex = i;
                }
            }
        }
        if(isRunning){
            n.endIndex = size;
            n.keyword = s.substring(n.startIndex,n.endIndex);
            list.add(n);
        }
        return list;
    }

    static class Node{
        String keyword;
        int startIndex;
        int endIndex;

    }

}
