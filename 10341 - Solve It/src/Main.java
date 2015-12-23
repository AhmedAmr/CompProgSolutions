import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 12/23/15.
 */
public class Main {
    static double EPS = 0.0000000001;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()) {
            ArrayList<Integer> line = readInts(nextLine(in));
            int p = line.get(0);
            int q = line.get(1);
            int r = line.get(2);
            int s = line.get(3);
            int t = line.get(4);
            int u = line.get(5);
            double res = solve(p, q, r, s, t, u);
            DecimalFormat f = new DecimalFormat("0.0000");
            if(res==-1){
                System.out.println("No solution");
            }else{
                System.out.println(f.format(res));
            }
        }

    }

    public static double solve(int p , int q,int r,int s,int t,int u){
        double begin = calculate(0,p,q,r,s,t,u);
        double last = calculate(1,p,q,r,s,t,u);
        if(last<0&&begin<0)return -1;
        if(last>0&&begin>0)return -1;
        if(begin==0)return 0;
        if(last==0)return 1;
        double start = 0;
        double end = 1;
        double x = (start+end)/2;
        double res = calculate(x,p,q,r,s,t,u);
        while(Math.abs(res)>EPS){
            if(res<0){
                end=x;
            }else{
                start=x;
            }
            x = (start+end)/2;
            res = p*Math.exp(-1*x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*Math.pow(x,2)+u;
        }
        return x;
    }

    public static double calculate(double x,int p , int q,int r,int s,int t,int u){
        return p*Math.exp(-1*x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*Math.pow(x,2)+u;
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
