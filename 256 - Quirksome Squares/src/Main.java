import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AhmedAmr on 11/11/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String , ArrayList<String>> res = new HashMap<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<String> line = readStrings(nextLine(in));
        while(true){
            ArrayList<String> list = new ArrayList<>();
            if(!res.containsKey(line.get(0))) {
                int digits = Integer.parseInt(line.get(0));
                String format = "%0" + line.get(0) + "d";
                digits /= 2;
                int div = (int) Math.pow(10, digits);

                for (int i = 0; i < div; i++) {
                    int mult = i * i;
                    if (isQuirksome(i, mult, digits, div)) {
                        list.add(String.format(format, mult));
                    }
                }
                res.put(line.get(0),list);
            }else{
                list = res.get(line.get(0));
            }
            print(list,out);
            if(!in.ready()){
                break;
            }
            line = readStrings(nextLine(in));
        }

    }

    public static void print(ArrayList<String>list,PrintWriter out){
        for (String s : list) {
            out.append(s);
            out.append("\n");
        }
        out.flush();
    }


    public static boolean isQuirksome(int num,int square,int digits,int div){
        if(num == ((square%div)+(int)(square*1.0/div))) return true;
        return false;
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
