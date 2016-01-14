import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AhmedAmr on 1/14/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][]arr= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                int item = s.nextInt();
                arr[i][j]=item;
                if (i > 0) arr[i][j]+=arr[i-1][j];
                if(j>0) arr[i][j] += arr[i][j - 1];
                if(i>0&&j>0) arr[i][j]-=arr[i-1][j-1];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        //for each possible rectangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < n; l++) {
                        maxSum = Math.max(maxSum,getSum(arr,i,j,k,l));
                    }
                }
            }
        }
        System.out.println(maxSum);

    }

    public static int getSum(int[][] arr,int i,int j,int k, int l) {
        int sum = arr[k][l];
        if (i > 0) sum -= arr[i - 1][l];
        if (j > 0) sum -= arr[k][j - 1];
        if(i>0&&j>0)sum+=arr[i-1][j-1];
        return sum;
    }

    public static ArrayList<Integer> readInts(String line) {
        String[] arr = line.split(" ");
        ArrayList<Integer> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextReadyLine(BufferedReader in) throws IOException {
        if (!in.ready()) return null;
        String line = in.readLine();
        while (line.isEmpty()) {
            if (!in.ready())
                break;
            line = in.readLine();
        }
        return line;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }

}
