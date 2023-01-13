package ru.netology.Tournament.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void whenFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 800);
        Player player2 = new Player(2, "Igor", 200);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Piter", "Igor");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 400);
        Player player2 = new Player(2, "Igor", 700);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Piter", "Igor");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void whenPlayersEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 300);
        Player player2 = new Player(2, "Igor", 300);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Piter", "Igor");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void notFoundExceptionWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 400);
        Player player2 = new Player(2, "Igor", 700);

        game.register(player1);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Piter","Igor"));
    }
    @Test
    public void notFoundExceptionWhenFirstPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 400);
        Player player2 = new Player(2, "Igor", 700);

        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Piter","Igor"));
    }

    @Test
    public void notFoundExceptionWhenBothPlayersIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Piter", 400);
        Player player2 = new Player(2, "Igor", 700);


        Assertions.assertThrows(NotFoundException.class, () -> game.round("Piter","Igor"));
    }
}