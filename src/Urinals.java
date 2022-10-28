// Author: Sathwik Reddy Dontham
// GitHub: https://github.com/sathwikreddyd/ica8Testing
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
public class Urinals {
    List<String> s;
    public boolean goodString (String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == '1' && str.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }
    public void openFile(String path) {

    }
    public String getString() {
        return "null";
    }
    public int countUrinals(String str) {
        if (str.length() == 0 || (str.length() == 1 && str.charAt(0) == '1')) {
            return 0;
        }
        if(str.length() == 1 && str.charAt(0) == '0') {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < str.length() - 1; i++) {
            boolean flag = false;
            while(str.charAt(i) == '1') { i++; flag = true;}
            if(flag) { i++; }
            if(i + 1 == str.length()) {
                count++;
            }
            else if(i + 1 > str.length()) {
                break;
            }
            if (str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                count++;
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}