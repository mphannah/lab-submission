import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {
    // write a test showing kevin and annies restaurants inserting/removing/rehashing properly

    AnniesRamenBar anniesRamenBar = new AnniesRamenBar();

    @Test
    public void anniesRamenBarTest() {
        Party party1 = new Party("Smith");
        Party party2 = new Party("Sally");
        Party party3 = new Party("Grace");
        Party party4 = new Party("Rob");
        Party party5 = new Party("Bob");

        anniesRamenBar.insert(party1);
        anniesRamenBar.insert(party2);
        System.out.println(anniesRamenBar.getTables());
        anniesRamenBar.insert(party3);
        assertEquals(11, anniesRamenBar.getTables().size());
        anniesRamenBar.insert(party4);
        anniesRamenBar.insert(party5);
        System.out.println(anniesRamenBar.getTables());
        anniesRamenBar.removeParty(party2);
        System.out.println(anniesRamenBar.getTables() + "\n");
    }

    KevinsSushiBar kevinsSushiBar = new KevinsSushiBar();

    @Test
    public void kevinsSushiBarTest() {
        Party party1 = new Party("Smith");
        Party party2 = new Party("Sally");
        Party party3 = new Party("Grace");
        Party party4 = new Party("Rob");
        Party party5 = new Party("Bob");

        kevinsSushiBar.insert(party1);
        kevinsSushiBar.insert(party2);
        System.out.println(kevinsSushiBar.getTables());
        kevinsSushiBar.insert(party3);
        assertEquals(11, kevinsSushiBar.getTables().size());
        kevinsSushiBar.insert(party4);
        kevinsSushiBar.insert(party5);
        System.out.println(kevinsSushiBar.getTables());
        kevinsSushiBar.removeParty(party4);
        System.out.println(kevinsSushiBar.getTables());
    }
}
