import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        while(n!=0){
            int arr[] = new int[100];
            String[] line = nextLine(in).split(" ");
            for (String s : line) {
                if(!s.isEmpty())
                    arr[Integer.parseInt(s)]++;
            }
            boolean isFirst = true;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    if(!isFirst)
                        out.append(" ");
                    else
                        isFirst = false;
                    out.append(String.valueOf(i));
                }
            }
            out.append("\n");
            out.flush();
            n = readInts(nextLine(in)).get(0);
        }
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

