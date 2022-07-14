import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class HumanTest {

    Human human;

    @BeforeEach
    void Setup(){
        System.out.println("I am BeforeEach");
        human = new Human(8, 5, "Player", 5, 10);
    }

    @Test
    void getHealth() {
        assertEquals(8, human.getHealth(), "Testing getHealth()");
    }

    @Test
    void getStrength() {
        assertEquals(5, human.getStrength(), "Testing getStrength()");
    }

    @Test
    void getName() {
        assertEquals("Player", human.getName(), "Testing getName()");
    }

    @Test
    void getX() {
        assertEquals(5, human.getX(), "Testing getX()");
    }

    @Test
    void getY() {
        assertEquals(10, human.getY(), "Testing getY()");
    }

    @AfterEach
    void tearDown(){
        System.out.println("I am in AfterEach()");
    }
}