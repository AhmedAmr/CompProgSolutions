import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/25/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            for (int i = 0; i < line.size(); i++) {
                int n = Integer.parseInt(line.get(i));
                if(n==0)return;;
                goldbach(n);
            }
            line = readStrings(in.readLine());
        }
    }

    public static void goldbach(int n){
        if(isPrime(n-2)){
            System.out.println(n+" = "+2+" + "+(n-2));
            return;
        }else{
            for (int i = 3; i <= n; i+=2) {
                if(isPrime(i)){
                    if(isPrime(n-i)){
                        System.out.println(n+" = "+i+" + "+(n-i));
                        return;
                    }
                }
            }
        }

    }

    public static boolean isPrime(int n){
        if(n==2)return true;
        if(n==3)return true;
        if(n==5)return true;
        if(n%2==0)return false;
        if(n%3==0)return false;
        if(n%5==0)return false;
        int size = (int) Math.ceil(Math.sqrt(n));
        for (int i = 7; i <= size; i++) {
            if(n%i==0)return false;
        }
        return true;
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
