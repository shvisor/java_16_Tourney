package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Player 1", 110);
    Player player2 = new Player(2, "Player 2", 105);
    Player player3 = new Player(3, "Player 3", 100);
    Player player4 = new Player(4, "Player 4", 120);
    Player player5 = new Player(5, "Player 5", 105);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void shouldWinFirstPlayer() {

        int expected = 1;
        int actual = game.round("Player 2", "Player 3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {

        int expected = 2;
        int actual = game.round("Player 1", "Player 4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDrawnGame() {

        int expected = 0;
        int actual = game.round("Player 2", "Player 5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredFirstPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 6", "Player 3");
        });
    }

    @Test
    public void shouldNotRegisteredSecondPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player 2", "Player 6");
        });
    }
}
