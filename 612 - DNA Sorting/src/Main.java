import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        ArrayList<Node> list= new ArrayList<>();
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            list.clear();
            in.readLine();
            int rows = Integer.parseInt(in.readLine().split(" ")[1]);
            for (int j = 0; j < rows; j++) {
                Node node = new Node(in.readLine().toCharArray(),j);
                list.add(node);
            }
            Collections.sort(list);
            for (Node node : list) {
                out.append(new String(node.dna));
                out.append("\n");
                out.flush();
            }
            if(i+1<n) {
                out.append("\n");
                out.flush();
            }
        }

    }


    //Investion
    public static InversionNode getInversionIndex(char[] arr,int start,int end){
        //Divide
        if(start>=end){
            char[] arr1 = new char[1];
            arr1[0] = arr[start] ;
            return new InversionNode(arr1,0) ;
        }
        int center = (end+start)/2;
        InversionNode left = getInversionIndex(arr, start, center);
        InversionNode right = getInversionIndex(arr,center+1,end);
        //Conquer
        int i = 0;
        int j = 0;
        int current=0;
        int leftSize = left.arr.length;
        int rightSize = right.arr.length;
        InversionNode res = new InversionNode(new char[leftSize+rightSize],left.inversionIndx+right.inversionIndx);
        while(i<leftSize && j<rightSize){
            if(left.arr[i]<=(right.arr[j])){
                res.arr[current] = left.arr[i];
                i++;
            }else{
                res.inversionIndx+=(leftSize-i);
                res.arr[current] = right.arr[j];
                j++;
            }
            current++;
        }
        while(i<leftSize){
            res.arr[current] = left.arr[i];
            current++;
            i++;
        }
        while(j<rightSize){
            res.arr[current] = right.arr[j];
            current++;
            j++;
        }
        return res;
    }


    public static class InversionNode{
        char[] arr;
        long inversionIndx=0;

        public InversionNode(char[] arr,long inversionIndx){
            this.arr = arr;
            this.inversionIndx = inversionIndx;
        }
    }

    public static Character[] getCharacterArray(char[] chars){
        int size = chars.length;
        Character[] arr = new Character[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Character(chars[i]);
        }
        return arr;
    }



    public static class Node implements Comparable<Node>{
        int idx;
        char[] dna;
        int sortedness;
        int size;

        public Node(char[] arr,int idx){
            this.dna = arr;
            this.size = arr.length;
            this.sortedness = this.getSortedness2();
            this.idx = idx;
        }

        public int getSortedness(){
            int counter = 0;
            for (int i = 0; i < size-1; i++) {
                char c = dna[i];
                for (int j = i+1; j < size; j++) {
                    if(c>dna[j])counter++;
                }
            }
            return counter;
        }

        public int getSortedness2(){
            //apply merge sort

            return (int)getInversionIndex(this.dna,0,this.size-1).inversionIndx;
        }


        @Override
        public int compareTo(Node o) {
            if(this.sortedness < o.sortedness) return -1;
            if(this.sortedness > o.sortedness) return 1;

            if(this.idx < o.idx) return -1;
            if(this.idx > o.idx) return 1;

            return 0;
        }
    }
}

