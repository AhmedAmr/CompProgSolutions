import java.io.PrintStream;

/**
 * Created by AhmedAmr on 9/13/15.
 */
public class Main {

    public static void main(String[] args) {
        char[] arr = {'a','b','c'};
        PrintStream s = new PrintStream(System.out);
        solve(0,1,0,arr,3,s);
        s.flush();
    }


    public static void solve(int i , int j , int idnt,char[] arr , int size,PrintStream out ){
        if(j == size+1){
            printWrite(arr, out);
            return;
        }
        if(j < size)
            printIf(arr, i, j, out);
        solve(i+1,j+1,idnt,arr,size,out);
        if(j==size){

            swap(arr, i, j);
            solve(i + 1, j + 1, idnt, arr, size, out);
        }else{
            printElseIf(arr,i,j,out);
            swap(arr, i, j);
            solve(i+1,j+1,idnt,arr,size,out);
        }


    }

    public static void printArr(char[] arr,PrintStream out){
        out.append(arr[0]);
        int size = arr.length;
        for (int i = 1; i <size; i++) {
            out.append(',');
            out.append(arr[i]);
        }
    }
    public static void printWrite(char[] arr,PrintStream out){
        out.append("writeln(");
        printArr(arr, out);
        out.append(")\n");
    }
    public static void printRead(char[] arr,PrintStream out) {
        out.append("readln(");
        printArr(arr, out);
        out.append(")\n");
    }

    public static void printIf(char[] arr,int i ,int j,PrintStream out) {
        out.append("if ");
        out.append(arr[i]);
        out.append(" < ");
        out.append(arr[j]);
        out.append(" then\n");
    }

    public static void printElse(PrintStream out){
        out.append("else\n");
    }

    public static void printElseIf(char[] arr,int i ,int j,PrintStream out) {
        out.append("else if ");
        out.append(arr[i]);
        out.append(" < ");
        out.append(arr[j]);
        out.append(" then\n");
    }

    private static void swap (char[] arr , int i , int j){
        if(i > arr.length-1) return;
        if(j > arr.length-1) return;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


