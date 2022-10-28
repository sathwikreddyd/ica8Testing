import org.junit.jupiter.api.*;

public class UrinalsTest {

    @Test
    void testGoodString () {
        Assertions.assertEquals(true, (new Urinals()).goodString("0100"));
        Assertions.assertEquals(false, (new Urinals()).goodString("0110"));
        System.out.println("====== Sathwik Reddy Dontham == TEST ONE EXECUTED =======");
    }
}
