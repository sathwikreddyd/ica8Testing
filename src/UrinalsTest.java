import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UrinalsTest {

    @Test
    void testGoodString () { //checking whether a string is good or not
        Assertions.assertEquals(true, (new Urinals()).goodString("0100"));
        System.out.println("====== Sathwik Reddy Dontham == TEST ONE EXECUTED =======");
    }

    @Test
    void testCountUrinals() { //checking whether countUrinals is giving correct output
        Assertions.assertEquals(2, (new Urinals()).countUrinals("000"));
        System.out.println("====== Sathwik Reddy Dontham == TEST TWO EXECUTED =======");
    }

    @Test
    void testOpenFile() { //check the no. of input lines of file matching with actual file
        Urinals u = new Urinals();
        u.openFile("src/input/urinal.dat");
        Assertions.assertEquals(4, u.s.size());
        System.out.println("====== Sathwik Reddy Dontham == TEST THREE EXECUTED =======");
    }

    @Test
    void testWriteToFile() { //test whether output contains same no. of lines as input
        Urinals u = new Urinals();
        u.openFile("src/input/urinal.dat");
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0;i < u.s.size();i++) {
            l.add(u.countUrinals(u.s.get(i)));
        }
        int k = u.writeToFile(l);
        try {
            if(k == 0) {
                Assertions.assertEquals(4, Files.readAllLines(Paths.get("src/output/rule.txt")).size());
            }
            else {
                Assertions.assertEquals(4, Files.readAllLines(Paths.get("src/output/rule" + k + ".txt")).size());
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println("====== Sathwik Reddy Dontham == TEST FOUR EXECUTED =======");
    }
}
