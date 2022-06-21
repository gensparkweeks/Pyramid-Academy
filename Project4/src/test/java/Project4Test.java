import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

class Project4Test {

    @BeforeEach
    void setUp() {
        System.out.println("We are in Before Each...");
    }

    @DisplayName("Testing solution Project4")
    @Test
    void guestName() {
        System.out.println("We are in guestName test...");
        assertEquals("Bryan", Project4.guestName());
    }

    @AfterEach
    void tearDown() {
        System.out.println("We are in After Each...");
    }


}
    