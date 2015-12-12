import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by AhmedAmr on 11/17/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> line = readInts(nextLine(in));
        PrintWriter out  = new PrintWriter(System.out);
        int t = line.get(0);
        for (int i = 0; i < t; i++) {
            int l = readInts(nextLine(in)).get(0);
            int[][] arr = new int[5][5];
            for (int j = 0; j < l; j++) {
                line = readInts(nextLine(in));
                arr[line.get(0)][line.get(1)] = line.get(2);
            }
            ArrayList<Integer> answer = new ArrayList<>();
            int minSum=Integer.MAX_VALUE;
            Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    Iterator<Integer> it1 = o1.iterator();
                    Iterator<Integer> it2 = o2.iterator();
                    while(it1.hasNext()){
                        int v1= it1.next();
                        int v2= it2.next();
                        if(v1<v2) return -1;
                        if(v1>v2) return 1;
                    }
                    return 0;
                }
            };
            for (int r = 0; r < 21; r++) {
                for (int j = r+1; j < 22; j++) {
                    for (int k = j+1; k < 23; k++) {
                        for (int f = k+1; f < 24; f++) {
                            for (int m = f+1; m < 25; m++) {
                                ArrayList<Integer> off = new ArrayList<>();
                                off.add(r);
                                off.add(j);
                                off.add(k);
                                off.add(f);
                                off.add(m);
                                int min = minDistanceToOffice(arr,off);
                                if(min==minSum){
                                    if(answer.size()==0 || comparator.compare(off,answer)<0){
                                        answer=new ArrayList<>(off);
                                        minSum = min;
                                    }
                                }else if(min<minSum){
                                    answer=new ArrayList<>(off);
                                    minSum = min;
                                }
                            }
                        }
                    }
                }
            }
            print(answer,out);
        }
    }
    public static void print(ArrayList<Integer>list,PrintWriter out){
        out.append(String.valueOf(list.get(0)));
        list.remove(0);
        for (Integer integer : list) {
            out.append(" ");
            out.append(String.valueOf(integer));
        }
        out.append("\n");
        out.flush();
    }

    public static int minDistanceToOffice(int[][] arr ,ArrayList<Integer>list){
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int l = 0; l < 5; l++) {
                int min = Integer.MAX_VALUE;
                for (Integer integer : list) {
                    min = Math.min(min, distanceToOffice(arr, integer, i, l));
                }
                sum+=min;
            }
        }
        return sum;
    }

    public static int distanceToOffice(int[][] arr , int i,int fromX , int fromY){
        int[] cord = getCord(i);
        return arr[fromX][fromY]*(Math.abs(fromX-cord[0])+Math.abs(fromY-cord[1]));
    }

    public static int[] getCord(int i){
        int[] arr=  new int[2];
        arr[0]=i/5;
        arr[1]=i%5;
        return arr;
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
