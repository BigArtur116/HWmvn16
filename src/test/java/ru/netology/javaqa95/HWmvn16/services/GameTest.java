package ru.netology.javaqa95.HWmvn16.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    Player petya96 = new Player(12, "Петя", 23);
    Player kolya44 = new Player(18, "Коля", 11);
    Player petya88 = new Player(56, "Петя", 8);
    Player egor16 = new Player(41, "Егор", 23);


    @Test
    public void player1MostWins() {
        game.register(petya96);
        game.register(kolya44);

        Assertions.assertEquals(1, game.round("Петя", "Коля"));

//        game.register(petya88);
//        Assertions.assertEquals(1, game.round("Петя", "Петя")); // Сравнивает только petya96 с petya96, а не с petya96 с petya88.
//        Assertions.assertEquals(1, game.round(petya96.getName(),petya88.getName())); // Нужно сравнивать по id

    }

    @Test
    public void player2MostWins() {
        game.register(petya88);
        game.register(kolya44);

        Assertions.assertEquals(2, game.round("Петя", "Коля"));
    }

    @Test
    public void roundDraw() {
        game.register(petya96);
        game.register(egor16);

        Assertions.assertEquals(0, game.round("Петя", "Егор"));
    }

    @Test
    public void notRegistredPlayer1() {

        game.register(egor16);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Егор"));
    }

    @Test
    public void notRegistredPlayer2() {

        game.register(egor16);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Егор", "Петя"));
    }


}