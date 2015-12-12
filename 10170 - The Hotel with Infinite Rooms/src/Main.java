import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AhmedAmr on 10/13/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(in.ready()){
            String[] line = in.readLine().split(" ");
            long s = Long.parseLong(line[0]);
            long d = Long.parseLong(line[1]);
            System.out.println((long)Math.ceil(solveQuadraticEquation(1,1,(-1*s*(s-1)-2*d))));
        }
    }


    public static double solveQuadraticEquation(long a,long b,long c){
        double temp1 = java.lang.Math.sqrt(b * b - 4 * a * c);
        double root =(-b +temp1) / (2*a) ;
        return root;
    }

}
