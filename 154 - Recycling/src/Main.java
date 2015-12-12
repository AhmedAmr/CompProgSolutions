import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AhmedAmr on 11/13/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> line = readStrings(nextLine(in));
        while(!line.get(0).equals("#")){
            // 0//r  1//o  2//y  3//g  4//b
            ArrayList<Character[]> list = new ArrayList<>() ;
            while(!line.get(0).startsWith("e")){
                line = readQuery(line.get(0));
                Character[] arr = new Character[5];
                for (String s : line) {
                    int idex = getColorIndex(s.charAt(0));
                    arr[idex] = s.charAt(2);
                }
                list.add(arr);
                line = readStrings(nextLine(in));
            }
            int rows = list.size();
            int[][] values = new int[rows][5];
            for (int i = 0; i <rows; i++) {
                Character[] currentRow = list.get(i);
                for (int j = 0; j < 5; j++) {
                    char currentItem = currentRow[j];
                    for (Character[] characters : list) {
                        if(characters[j]!=currentItem) values[i][j]++;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < rows; i++) {
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum+=values[i][j];
                }
                if(sum<min){
                    min=sum;
                    index = i;
                }
            }
            System.out.println((index+1));
            line = readStrings(nextLine(in));
        }
    }

    public static int getColorIndex(char c){
        if(c=='r')return 0;
        if(c=='o')return 1;
        if(c=='y')return 2;
        if(c=='g')return 3;
        return 4;
    }

    public static ArrayList<String> readStrings(String line) {
        String[] arr = line.split(" ");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static ArrayList<String> readQuery(String line) {
        String[] arr = line.split(",");
        ArrayList<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }

    public static String nextLine(BufferedReader in) throws IOException {
        String line = in.readLine();
        while (line.isEmpty()) {
            line = in.readLine();
        }
        return line;
    }


}
