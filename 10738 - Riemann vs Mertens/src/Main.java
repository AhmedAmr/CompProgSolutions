import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by AhmedAmr on 10/27/15.
 */
public class Main {
    static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,911,919,929,937,941,947,953,967,971,977,983,991,997};
    static int primesLength = primes.length;
    static int[] mem = new int[1000001];
    static int last = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ArrayList<String> line = readStrings(in.readLine());
        while(!line.get(0).equals("0")){
            int n = Integer.parseInt(line.get(0));
            int muT;
            int muN;
            if(last >= n){
                muT = mem[n];
            }else{
                for (int i = last+1; i <= n; i++) {
                    mem[i] +=mem[i-1]+ mu(i);
                }
                last = n;
                muT = mem[n];
            }
            if(n==1) muN = 1;
            else muN = mem[n]-mem[n-1];
            print(out,n,muT,muN);
            line = readStrings(in.readLine());
        }
    }



    public static void print(PrintWriter out , int n , int muT, int muN ){
        String muNS = String.valueOf(muN);
        String muTS = String.valueOf(muT);
        String nS = String.valueOf(n);
        int size = 8-nS.length();
        for (int i = 1; i <= size ; i++) {
            out.append(" ");
        }
        out.append(nS);
        size = 8-muNS.length();
        for (int i = 1; i <= size ; i++) {
            out.append(" ");
        }
        out.append(muNS);
        size = 8-muTS.length();
        for (int i = 1; i <= size ; i++) {
            out.append(" ");
        }
        out.append(muTS);
        out.append("\n");
        out.flush();
    }


    public static int mu(int n){
        if(n==1)return 1;
        if(n<=last) return mem[n];
        if(isPrime(n))return -1;
        int i = 0;
        int res = 1;
        while(n!=1 && i<primesLength){
            if(n%primes[i]==0){
                n=n/primes[i];
                res*=-1;
                if(n%primes[i]==0)return 0;
            }
            i++;
        }
        if(n!=1)
            return res*-1;
        return res;
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
