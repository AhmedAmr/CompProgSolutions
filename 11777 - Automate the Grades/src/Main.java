import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(System.out);
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            String line[] = in.readLine().split(" ");
            double average = alternativeGetAverage(line);
            double grade = 0;
            for (int j = 0; j < 4; j++) {
                grade+=Integer.parseInt(line[j]);
            }
            grade+=average;
            out.append("Case ");
            out.append(String.valueOf((i + 1)));
            out.append(": ");
            out.append(getGrade(grade));
            out.append("\n");
            out.flush();
        }
        out.close();
    }

    public static double getAverage(String[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 4 ; i < 7 ; i++) {
                list.add(Integer.parseInt(arr[i]));
        }
        list.remove(Collections.min(list));
        return (list.get(0)+list.get(1))/2;
    }

    public static double alternativeGetAverage(String[] arr){
        int num1 = Integer.parseInt(arr[4]);
        int num2=Integer.parseInt(arr[5]);
        int num3=Integer.parseInt(arr[6]);
        if(num1 <= num2 && num1 <= num3){
            return (num2+num3)/2;
        }
        if(num2 <= num1 && num2 <= num3){
            return (num1+num3)/2;
        }
        if(num3 <= num1 && num3 <= num2) {
            return (num1 + num2) / 2;
        }
        return 0;
    }

    public static String getGrade(double grade){
        if(grade>89) return "A";
        if(grade > 79) return "B";
        if(grade > 69) return "C";
        if(grade > 59) return "D";
        return "F";
    }
}

