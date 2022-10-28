import org.junit.jupiter.api.*;

public class UrinalsTest {

    @Test
    void testGoodString () {
        Assertions.assertEquals(true, (new Urinals()).goodString("0100"));
        System.out.println("====== Sathwik Reddy Dontham == TEST ONE EXECUTED =======");
    }

    @Test
    void testCountUrinals() {
        Assertions.assertEquals(-1, (new Urinals()).countUrinals("1101"));
        System.out.println("====== Sathwik Reddy Dontham == TEST TWO EXECUTED =======");
    }

    @Test
    void testOpenFile() {
        Urinals u = new Urinals();
        u.openFile("src/input/urinal.dat");
        Assertions.assertEquals(2, u.s.size());
        System.out.println("====== Sathwik Reddy Dontham == TEST THREE EXECUTED =======");
    }
}
