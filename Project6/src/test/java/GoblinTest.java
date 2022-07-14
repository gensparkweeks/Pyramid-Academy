import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class GoblinTest {

    Goblin goblin;

    @BeforeAll()
    public static void beforeClass () {
        System.out.println("I am in BeforeAll");
    }

    @BeforeEach
    void SetUp() {
        System.out.println("I am in Before Each");
        goblin = new Goblin(10, "Kraduz", 1, 1);
    }

    @DisplayName("Testing getStrength")
    @Test
    void getStrength() {
        assertEquals(10, goblin.getStrength());
    }

    @DisplayName("Testing getName")
    @Test
    void getName() {
        assertEquals("Kraduz", goblin.getName());
    }

    @DisplayName("Testing getX")
    @Test
    void getX() {
        assertEquals(1, goblin.getX());
    }

    @DisplayName("Testing getY")
    @Test
    void getY() {
        assertEquals(1, goblin.getY());
    }

    @AfterEach
    void tearDown(){
        System.out.println("I am in AfterEach");
    }

    @AfterAll()
    public static void afterClass(){
        System.out.println("I am in BeforeAll");
    }

}