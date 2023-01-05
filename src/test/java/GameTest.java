import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testStrength1() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 60);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStrength2() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 160);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testStrengthEquals() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 100);

        game.register(max);
        game.register(alex);

        int actual = game.round("Max", "Alex");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNotRegisteredPlayer1() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 100);

        game.register(max);
        game.register(alex);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Tom", "Alex"));
    }

    @Test
    public void testNotRegisteredPlayer2() {
        Game game = new Game();
        Player max = new Player(1, "Max", 100);
        Player alex = new Player(2, "Alex", 100);

        game.register(max);
        game.register(alex);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Max", "Ann"));
    }
}
