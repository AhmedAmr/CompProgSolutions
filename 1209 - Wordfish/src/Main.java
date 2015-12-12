import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        SortedSet<Node> set = new TreeSet<>();
        while(in.ready()){
            set.clear();
            String word = in.readLine();
            String per = word;
            set.add(new Node(0,word,minimumAbsDistance(word)));
            for (int i = 1; i < 11; i++) {
                per = nextPermutation(per);
                if(per==null)
                    break;
                set.add(new Node(i,per,minimumAbsDistance(per)));
            }
            per = word;
            for (int i = -1; i > -11; i--) {
                per = prevPermutation(per);
                if(per==null)
                    break;
                set.add(new Node(i,per,minimumAbsDistance(per)));
            }
            Node first = set.first();
            out.append(first.per);
            out.append(String.valueOf(first.dist));
            out.append("\n");
            out.flush();

        }
    }

    public static int minimumAbsDistance(String s){
        int min = Integer.MAX_VALUE;
        char[] arr = s.toCharArray();
        int size = s.length();
        for (int i = 0; i < size-1; i++) {
            int diff = Math.abs(arr[i]-arr[i+1]);
            if(diff<min)
                min = diff;
        }
        return min;
    }

    public static String prevPermutation(String line){
        int interval = 0;
        char[] arr = line.toCharArray();
        boolean isFound = false;
        int size = arr.length;
        for (int i = size - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                //stop here
                interval = i - 1;
                isFound = true;
                break;
            }
        }
        String result;
        if (isFound) {
            int pos = prev(arr[interval], arr, interval);
            swap(arr, pos, interval);
            sort(arr, (interval + 1),false);
            result = new String(arr);

        } else {
            return null;
        }
        return result;
    }

    public static String nextPermutation(String line) {
        int interval = 0;
        char[] arr = line.toCharArray();
        boolean isFound = false;
        int size = arr.length;
        for (int i = size - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                //stop here
                interval = i - 1;
                isFound = true;
                break;
            }
        }
        String result;
        if (isFound) {
            int pos = next(arr[interval], arr, interval);
            swap(arr, pos, interval);
            sort(arr, (interval + 1),true);
            result = new String(arr);

        } else {
            return null;
        }
        return result;
    }

    private static int prev(char c, char[] arr, int interval){
        int diff = Integer.MAX_VALUE;
        int index = -1;
        int size = arr.length;
        for (int i = interval+1; i < size; i++) {
            int temp = c-arr[i];
            if(temp > 0 && temp < diff){
                diff = temp;
                index = i;
            }
        }
        return index;
    }


    private static int next(char c, char[] arr, int interval) {
        int diff = Integer.MAX_VALUE;
        int index = -1;
        int size = arr.length;
        for (int i = interval+1; i < size; i++) {
            int temp = arr[i]-c;
            if(temp > 0 && temp < diff){
                diff = temp;
                index = i;
            }
        }
        return index;
    }

    /*
    ------- Swaps 2 elements in an array
     */
    private static void swap (char[] arr , int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sort(char[]arr , int start,boolean asc){
        ArrayList<Character> c = new ArrayList<>();
        int size = arr.length;
        for (int i = start; i < size ; i++) {
            c.add(arr[i]);
        }
        Collections.sort(c);
        if(asc) {
            for (int i = start; i < size; i++) {
                arr[i] = c.get(i - start);
            }
        }else{
            for (int i = start; i < size; i++) {
                arr[i] = c.get(size-1-i);
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int seqNum;
        String per;
        int dist;

        public Node(int seqNum , String per , int dist)
        {
            this.seqNum = seqNum;
            this.per = per;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o) {
            if(this.dist > o.dist) return -1;
            if(this.dist < o.dist) return 1;

            if(this.seqNum < o.seqNum) return -1;
            if(this.seqNum > o.seqNum) return 1;

            return 0;
        }
    }

}


