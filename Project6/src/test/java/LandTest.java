import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    Land land = new Land();

    @Test
    void getGoblinName() {
        assertEquals("Kraduz Goblin", land.getGoblinName());
    }

    @Test
    void getTreasureName() {
        assertEquals("Sword", land.getTreasureName());
    }

//    @Test
//    void getString() {
//       assertEquals("Player", land.getString("Type your name: "));
//    }

    @Test
    void getAnyRandom() {
        assertEquals(6, land.getAnyRandom(10));
    }
}