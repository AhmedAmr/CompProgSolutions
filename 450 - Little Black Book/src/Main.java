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
        int n = Integer.parseInt(in.readLine());
        ArrayList<Record>list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String dep = in.readLine();
            String line = in.readLine();
            while(true){
                if(line.isEmpty())
                    break;
                Record r = new Record();
                String[] arr = line.split(",");
                r.title = arr[0];
                r.firstName = arr[1];
                r.lastName = arr[2];
                r.street = arr[3];
                r.hP = arr[4];
                r.wP = arr[5];
                r.mail = arr[6];
                r.department = dep;
                list.add(r);
                if(in.ready())
                    line = in.readLine();
                else
                    break;
            }

        }
        Collections.sort(list);
        for (Record record : list) {
            out.append(record.toString());
        }
        out.flush();

    }




    public static class Record implements Comparable<Record>{
        String department;
        String title;
        //Title, First Name, Last Name, Street Address, Home Phone, Work Phone, and Campus Mailbox.
        String firstName;
        String lastName;
        String street;
        String hP;
        String wP;
        String mail;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("----------------------------------------\n");
            sb.append(title);
            sb.append(" ");
            sb.append(firstName);
            sb.append(" ");
            sb.append(lastName);
            sb.append("\n");
            sb.append(street);
            sb.append("\n");
            sb.append("Department: ");
            sb.append(department);
            sb.append("\n");
            sb.append("Home Phone: ");
            sb.append(hP);
            sb.append("\n");
            sb.append("Work Phone: ");
            sb.append(wP);
            sb.append("\n");
            sb.append("Campus Box: ");
            sb.append(mail);
            sb.append("\n");
            return sb.toString();
        }




        @Override
        public int compareTo(Record o) {
            return this.lastName.compareTo(o.lastName);
        }
    }
}
