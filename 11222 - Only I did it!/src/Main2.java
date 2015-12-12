import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            ArrayList<Integer> ArrayList1 = new ArrayList<Integer>();
            ArrayList<Integer> ArrayList2 = new ArrayList<Integer>();
            ArrayList<Integer> ArrayList3 = new ArrayList<Integer>();
            ArrayList<Integer> result1 = new ArrayList<Integer>();
            ArrayList<Integer> result2 = new ArrayList<Integer>();
            ArrayList<Integer> result3 = new ArrayList<Integer>();
            String[] arr = in.readLine().split(" ");
            int size = arr.length;
            for (int j = 1; j < size; j++) {
                int val = Integer.parseInt(arr[j]);
                if(!ArrayList1.contains(val))
                    ArrayList1.add(val);
            }

            arr = in.readLine().split(" ");
            size = arr.length;
            for (int j = 1; j < size; j++) {
                int val = Integer.parseInt(arr[j]);
                if(!ArrayList2.contains(val))
                    ArrayList2.add(val);
            }

            arr = in.readLine().split(" ");
            size = arr.length;
            for (int j = 1; j < size; j++) {
                int val = Integer.parseInt(arr[j]);
                if(!ArrayList3.contains(val))
                    ArrayList3.add(val);
            }
            ArrayList<Integer> temp = new ArrayList<Integer>();
            result1.addAll(ArrayList1);
            result1.addAll(ArrayList2);
            result1.addAll(ArrayList3);
            temp.addAll(ArrayList2);
            temp.addAll(ArrayList3);
            result1.removeAll(temp);


            temp = new ArrayList<Integer>();
            result2.addAll(ArrayList1);
            result2.addAll(ArrayList2);
            result2.addAll(ArrayList3);
            temp.addAll(ArrayList1);
            temp.addAll(ArrayList3);
            result2.removeAll(temp);


            temp = new ArrayList<Integer>();
            result3.addAll(ArrayList1);
            result3.addAll(ArrayList2);
            result3.addAll(ArrayList3);
            temp.addAll(ArrayList1);
            temp.addAll(ArrayList2);
            result3.removeAll(temp);

            ArrayList<Integer> sizes = new ArrayList<Integer>();
            sizes.add(result1.size());
            sizes.add(result2.size());
            sizes.add(result3.size());
            int max = Collections.max(sizes);

            System.out.println("Case #" + (i + 1) + ":");
            int current = result1.size();
            if(current == max){
                System.out.print("1 ");
                System.out.print(current);
                Collections.sort(result1);
                for (Integer integer : result1) {
                    System.out.print(" ");
                    System.out.print(integer);
                }
                System.out.println();
            }

             current = result2.size();
            if(current == max){
                System.out.print("2 ");
                System.out.print(current);
                Collections.sort(result2);
                for (Integer integer : result2) {
                    System.out.print(" ");
                    System.out.print(integer);
                }
                System.out.println();
            }

            current = result3.size();
            if(current == max){
                System.out.print("3 ");
                System.out.print(current);
                Collections.sort(result3);
                for (Integer integer : result3) {
                    System.out.print(" ");
                    System.out.print(integer);
                }
                System.out.println();
            }
        }
    }
}
