import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Created by AhmedAmr on 10/5/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        double dist = 0.0;
        double base = 0;
        int speed = 0;
        while(in.ready()){
            String line[] = in.readLine().split(" ");
            double hours = calcHours(line[0]);
            dist+=((hours-base)*speed);
            if(line.length == 1){
                out.append(line[0]);
                out.append(" ");
                DecimalFormat ft = new DecimalFormat("#0.00");
                out.append(String.valueOf(ft.format(dist)));
                out.append(" km\n");

                out.flush();
            }else{
                speed = Integer.parseInt(line[1]);
            }
            base = hours;
        }

    }

    public static double calcHours(String s){
        String[] arr = s.split(":");
        return (Integer.parseInt(arr[0])*3600+Integer.parseInt(arr[1])*60+Integer.parseInt(arr[2]))*1.0/3600;
    }

}
