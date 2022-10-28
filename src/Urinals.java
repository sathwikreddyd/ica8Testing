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
    public int countUrinals() {
        return 0;
    }
    public static void main(String[] args) {

    }
}