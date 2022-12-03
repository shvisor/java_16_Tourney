package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<Integer, String> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getId(), player.getName());
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

    public String findByName(String name) {
        for (Integer key : players.keySet()) {
            if (players.containsValue(name)) {
                String value = players.get(name);
                return value;
            }
        }
        return null;
    }
}
