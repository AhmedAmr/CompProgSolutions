import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by AhmedAmr on 10/2/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        HashMap<String,Integer> map = new HashMap<>();
        String [] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);

        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            map.put(input[0],(int)Math.floor(Double.parseDouble(input[1])*10));
        }
        n = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");
            out.append("Guess #");
            out.append(String.valueOf((i+1)));
            if(isCompare(input,map)){
                out.append(" was correct.\n");
            }else{
                out.append(" was incorrect.\n");
            }
        }
        out.flush();
    }

    public static boolean isCompare(String[] line , HashMap<String,Integer> map){
        int size =  line.length;
        int sum = 0;
        for (int i = 0; i < size-2; i+=2) {
            sum+=map.get(line[i]);
        }
        int n = Integer.parseInt(line[size - 1])*10;
        String operation = line[size-2];
        int compare = Integer.compare(sum,n);
        if(operation.equals("<")){
            if(compare<0)return true;
            return false;
        }else if(operation.equals(">")){
            if(compare>0)return true;
            return false;
        }else if(operation.equals("<=")){
            if(compare<=0)return true;
            return false;
        }else if(operation.equals(">=")){
            if(compare>=0)return true;
            return false;
        }else{
            if(compare==0)return true;
            return false;
        }
    }


}
