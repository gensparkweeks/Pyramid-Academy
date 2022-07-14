import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class TreasureTest {

    Treasure treasure = new Treasure(10, "Dagger", 0, 0);

    @DisplayName("Testing GetHealth")
    @Test
    void getHealth() {
        assertEquals(10, treasure.getHealth(), "Testing getHealth()");
    }

    @Test
    void getName() {
        assertEquals("Dagger", treasure.getName(), "Testing getName");
    }

    @Test
    void getX() {
        assertEquals(0, treasure.getX(), "Testing getX()");
    }

    @Test
    void getY() {
        assertEquals(0, treasure.getY(), "Testing GetY()");
    }
}