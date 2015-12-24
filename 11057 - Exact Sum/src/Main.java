import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by AhmedAmr on 12/24/15.
 */
public class Main {
    static ArrayList<Integer>list ;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()) {
            int n = readInts(nextLine(in)).get(0);
            list = readInts(nextLine(in));
            int value = readInts(nextLine(in)).get(0);
            int diff = Integer.MAX_VALUE;
            int book1 = 0;
            int book2 = 0;
            Collections.sort(list);
            for (int i = 0; i < n; i++) {
                int temp1 = list.get(i);
                int rem = value - temp1;
                int temp2 = Collections.binarySearch(list, rem);
                int difference;
                if(temp2>=0 && temp2!=i) {
                    difference = Math.abs(list.get(temp2) - temp1);
                    if (rem != 0 && temp2 > -1 && diff > difference) {
                        book1 = i;
                        book2 = temp2;
                        diff = difference;
                    }
                }
            }

            if(list.get(book1)<list.get(book2))
                System.out.println("Peter should buy books whose prices are " + list.get(book1) + " and " + list.get(book2) + ".");
            else{
                System.out.println("Peter should buy books whose prices are " + list.get(book2) + " and " + list.get(book1) + ".");
            }
            System.out.println();
            in.readLine();
        }
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
