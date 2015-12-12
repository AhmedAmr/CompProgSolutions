

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();

        while(!line.equals("#")){
            int interval = 0;
            char[] arr = line.toCharArray();
            boolean isFound = false;
            int size = arr.length;
            for (int i = size-1; i > 0 ; i--) {
                if(arr[i-1] < arr[i]){
                    //stop here
                    interval = i-1;
                    isFound=true;
                    break;
                }
            }
            if(isFound)
            {
                int pos = next(arr[interval],arr,interval);
                swap(arr,pos,interval);
                sort(arr, (interval + 1));
                System.out.println(new String(arr));

            }else{
                System.out.println("No Successor");
            }
            line = in.readLine();
        }
    }

     static int next(char c, char[] arr, int interval) {
         int diff = Integer.MAX_VALUE;
         int index = -1;
         int size = arr.length;
         for (int i = interval+1; i < size; i++) {
             int temp = arr[i]-c;
             if(temp > 0 && temp < diff){
                 diff = temp;
                 index = i;
             }
         }
         return index;
    }

    static void swap (char[] arr , int i , int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(char[]arr , int start){
        ArrayList<Character> c = new ArrayList<Character>();
        int size = arr.length;
        for (int i = start; i < size ; i++) {
            c.add(arr[i]);
        }
        Collections.sort(c);
        for (int i = start; i < size ; i++) {
            arr[i] = c.get(i-start);
        }
    }
}
