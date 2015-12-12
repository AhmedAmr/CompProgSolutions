import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 10/26/15.
 */
public class Main {
    static ArrayList<Integer> primes;
    static int gSize = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        primes = new ArrayList<>();
        ArrayList<String> line = readStrings(in.readLine());
        int size= Integer.parseInt(line.get(0));
        for (int i = 0; i < size; i++) {
            line = readStrings(in.readLine());
            long start = Long.parseLong(line.get(0));
            long end = Long.parseLong(line.get(1));
            long sum = 0;
            for (long j = start; j <=end  ; j++) {

            }


        }
    }

    public static void updatePrimes(long last){

            int size = (int) Math.ceil(Math.sqrt(last));
        if(last>=2){
            primes.add(2);
            for (int i = 3; i < size ; i+=2) {
                if(isPrime(i))primes.add(i);
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

    //returns -1 if multiples was found
    //return the number of primes that divides num
    public static int isOnePrimeFactor(long num,int last,int sum){
        long len = primes.size();
        int s = sum;
        for (int i = last; i <len; i++) {
            if(num%primes.get(i)==0)s++;
            if(s>1) {
                return -1;
            }
        }
        return s;

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
