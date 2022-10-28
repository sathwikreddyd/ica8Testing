import org.junit.jupiter.api.*;

public class UrinalsTest {

    @Test
    void testGoodString () {
        Assertions.assertEquals(true, (new Urinals()).goodString("0100"));
        System.out.println("====== Sathwik Reddy Dontham == TEST ONE EXECUTED =======");
    }

    @Test
    void testCountUrinals() {
        Assertions.assertEquals(1, (new Urinals()).countUrinals("100001"));
        System.out.println("====== Sathwik Reddy Dontham == TEST TWO EXECUTED =======");
    }
}
