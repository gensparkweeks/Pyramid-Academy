import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UtilsProject5Test {

    UtilsProject5 util;

    @BeforeAll()
    public static void beforeClass(){
        System.out.println("I am in BeforeAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("We are in Before Each");
        util = new UtilsProject5();
    }

    @DisplayName("Testing getRandomLetter method")
    @Test
    void getRandomLetter() {
        assertEquals("portfolio", util.getRandomLetter());
    }

    @DisplayName("Testing printInitialHang method")
    @Test
    void printInitialHang() {
        assertEquals("_____", util.printInitialHang("react", ""));
    }

    @AfterEach
    void tearDown() {
        System.out.println("We are in After Each");
    }

    @AfterAll()
    public static void afterClass(){
        System.out.println("I am in AfterAll");
    }

}