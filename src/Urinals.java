// Author: Sathwik Reddy Dontham
// GitHub: https://github.com/sathwikreddyd/ica8Testing
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.io.*;
import java.util.*;
public class Urinals {
    public List<String> s;
    public boolean goodString (String str) { //checks to see if valid string
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != '0' || str.charAt(i) != '1') {
                return false;
            }
            if(str.charAt(i) == '1' && str.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }
    public void openFile(String path){ //opens a file in path specified
        try {
            s = Files.readAllLines(Paths.get(path));
        }
        catch(IOException e) {
            System.out.println("urinal.dat file is not present in src/input/ folder. Please check and re run the program");
        }
    }
    public int writeToFile(List<Integer> l) {
        int i = 0;
        while (true) {
            try {
                if(i == 0) {
                    s = Files.readAllLines(Paths.get("src/output/rule.txt"));
                }
                else {
                    s = Files.readAllLines(Paths.get("src/output/rule"+i+".txt"));
                }
                i++;
            }
            catch(IOException e) {
                break;
            }
        }
        try {
            FileWriter myWriter;
            if(i==0) {
                myWriter = new FileWriter("src/output/rule.txt");
            }
            else {
                myWriter = new FileWriter("src/output/rule" + i + ".txt");
            }
            for(int j : l) {
                myWriter.write(j+"\n");
            }
            myWriter.close();
            return i;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int countUrinals(String str) { //count number of urinals that can be used
        if(!goodString(str)) {
            return -1;
        }
        if (str.length() == 0 || (str.length() == 1 && str.charAt(0) == '1')) {
            return 0;
        }
        if(str.length() == 1 && str.charAt(0) == '0') {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            boolean flag = false;
            while(i<str.length() && str.charAt(i) == '1') {
                i++;
                flag = true;
            }
            if(flag) { i++; }
            if(i + 1 == str.length()) {
                count++;
                break;
            }
            else if(i + 1 > str.length()) {
                break;
            }
            else {
                if (str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                    count++;
                    i++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Urinals u = new Urinals();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input Format 1. Command Line 2. File (src/input/urinal.dat) ");
        int c = sc.nextInt();
        if(c == 1) {
            while(true) {
                System.out.println("Input string (Enter -1 to exit)");
                String k = sc.next();
                if(k.equals("-1")) {
                    break;
                }
                System.out.println("No. of urinals =  " + u.countUrinals(k));
            }
            sc.close();
        }
        else if (c == 2) {
            u.openFile("src/input/urinal.dat");
            if(u.s.size() == 0) {
                System.out.println("Empty File");
                System.exit(0);
            }
            ArrayList<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < u.s.size(); i++) {
                l.add(u.countUrinals(u.s.get(i)));
            }
            int k = u.writeToFile(l);
            if (k==0) {
                System.out.println("Successfully exported to src/output/rule.txt");
            }
            else {
                System.out.println("Successfully exported to src/output/rule" + k + ".txt");
            }
        }
        else {
            System.out.println("Closing due to incorrect input");
        }
    }
}