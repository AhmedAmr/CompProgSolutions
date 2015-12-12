import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/30/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            int size = Integer.parseInt(line.get(0));
            double [] arr = new double[size];
            double sum = 0;
            for (int i = 0; i < size; i++) {
                line = readStrings(in.readLine());
                arr[i] = Double.parseDouble(line.get(0));
                sum+=arr[i];
            }
            double part = sum/size;

            DecimalFormat df = new DecimalFormat("$0.00");
            part = round(part,2);
            double sol = getTransferAmount(part,arr,size);
            System.out.println(df.format(round(sol,2)));
            line = readStrings(in.readLine());
        }
    }

    public static double round(double k , int places){
        double multiplier = Math.pow(10,places);
        k*=multiplier;
        k=Math.round(k);
        k/=multiplier;
        return k;
    }


    public static double getTransferAmount(double k,double[] arr,int size){
        double sumPos = 0;
        double sumNeg = 0;
        for (int i = 0; i < size; i++) {
            if(arr[i]>k)sumPos+=(arr[i]-k);
            else sumNeg +=(k-arr[i]);
        }
        return sumPos>sumNeg?sumNeg:sumPos;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

}
