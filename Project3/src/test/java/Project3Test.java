import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

class Project3Test {


    @BeforeEach
    void Setup(){
        System.out.println("Before Each... ");

    }

    @DisplayName("Testing whatDragonIs() in Project3")
    @Test
    void whatDragonIs() {
        System.out.println("We are in whatDragonIs test");
        assertEquals("Hungry", Project3.whatDragonIs());
    }

    @AfterEach
    void tearDown(){
        System.out.println("After Each... ");

    }
}