package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.*;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.*;

public class GameEngine {
    private char[][] map;
    private Hero hero;
    private Enemy[] enemies;
    private Treasure[] treasures;

    public GameEngine() {
        map = new char[5][10];
        enemies = new Enemy[10];
        treasures = new Treasure[10];
    }

    public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures) {
        this.map = new char[5][10];
        this.map = map;
        this.hero = hero;
        this.enemies = new Enemy[enemies.length];
        this.enemies = enemies;
        this.treasures = new Treasure[treasures.length];
        this.treasures = treasures;
    }

    char[][] getMap() {
        return this.map;
    }

    //removes the first treasure
    public void collectTreasure() {
        for (int i = 0; i < treasures.length - 1; i++) {
            treasures[i] = treasures[i + 1];
        }
    }

    // returns the first enemy that has not yet been defeated
    Enemy undefeated() {
        for (Enemy e : enemies) {
            if (e.isAlive()) {
                return e;
            }
        }
        return enemies[0];
    }

    public boolean fight(Enemy enemy) {
        while (hero.isAlive() && enemy.isAlive()) {
            enemy.takeDamage(hero.attack());
            hero.takeDamage(enemy.attack());
        }
        return hero.isAlive();
    }


    String makeMove(int command) {

        if (command == 0 || command == 1 || command == 2 || command == 3) {

            if (hero.getPosition().isValidPosition(command)) {

                switch (goalPosition(command)) {
                    case '#':
                        return "Wrong move. There is an obstacle and you cannot bypass it.";
                    case '.':
                        changeMap(command);
                        hero.getPosition().ChangePosition(command);
                        return "You moved successfully to the next position.";
                    case 'G':
                        return "You have successfully passed through the dungeon. Congrats!";
                    case 'T':
                        String message = treasures[0].collect(hero);
                        collectTreasure();
                        changeMap(command);
                        hero.getPosition().ChangePosition(command);
                        return message;
                    case 'E':
                        if (!fight(undefeated())) {
                            return "Hero is dead! Game over!";
                        } else {
                            changeMap(command);
                            hero.getPosition().ChangePosition(command);
                            return "Enemy died.";
                        }

                }
            }

        }

        return "Unknown command entered.";
    }

    // returns the symbol that is at the place that we want to go
    public char goalPosition(int command) {

        switch (command) {
            case 0:
                return map[hero.getPosition().getVP()][hero.getPosition().getHP() - 1];
            case 1:
                return map[hero.getPosition().getVP() - 1][hero.getPosition().getHP()];
            case 2:
                return map[hero.getPosition().getVP()][hero.getPosition().getHP() + 1];
        }

        return map[hero.getPosition().getVP() + 1][hero.getPosition().getHP()];
    }


    // changes the map by moving the hero to the desired position and marking his
    // previous position
    public void changeMap(int command) {

        switch (command) {
            case 0:
                map[hero.getPosition().getVP()][hero.getPosition().getHP() - 1] = 'H';
                break;
            case 1:
                map[hero.getPosition().getVP() - 1][hero.getPosition().getHP()] = 'H';
                break;
            case 2:
                map[hero.getPosition().getVP()][hero.getPosition().getHP() + 1] = 'H';
                break;
            case 3:
                map[hero.getPosition().getVP() + 1][hero.getPosition().getHP()] = 'H';
        }
        map[hero.getPosition().getVP()][hero.getPosition().getHP()] = '.';

    }

}
