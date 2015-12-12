import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/11/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int [] cubes = new int[201];
        for (int i = 1; i <=200 ; i++) {
            cubes[i] = i*i*i;
        }
        for (int a = 6; a <=200 ; a++) {
            for (int b = 2; b <200 ; b++) {
                for (int c = b; c <200 ; c++) {
                    for (int d = c; d <200 ; d++) {
                        if(cubes[b]+cubes[c]+cubes[d]==cubes[a]) System.out.println("Cube = "+a+", Triple = ("+b+","+c+","+d+")");
                    }
                }
            }
        }
    }
}
