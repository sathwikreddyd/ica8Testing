import org.junit.jupiter.api.*;

public class UrinalsTest {

    @Test
    void testGoodString () {
        Assertions.assertEquals(false, (new Urinals()).goodString("abc"));
        System.out.println("====== Sathwik Reddy Dontham == TEST ONE EXECUTED =======");
    }
}
