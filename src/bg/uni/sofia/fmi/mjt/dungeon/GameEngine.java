package bg.uni.sofia.fmi.mjt.dungeon;

import bg.uni.sofia.fmi.mjt.dungeon.actor.*;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.*;

import java.util.Stack;

public class GameEngine {

    private static final int DUNGEON_WIDTH = 5;
    private static final int DUNGEON_HEIGHT = 10;
    private static final int LEFT = 0;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int UP = 1;
    private char[][] map;
    private Hero hero;
    private Stack<Enemy> enemies;
    private Stack<Treasure> treasures;

    public GameEngine() {
        map = new char[DUNGEON_WIDTH][DUNGEON_HEIGHT ];
        enemies = new Stack<>();
        treasures = new Stack<>();
    }

    public GameEngine(char[][] map, Hero hero, Stack<Enemy> enemies, Stack<Treasure> treasures) {
        this.map = new char[DUNGEON_WIDTH][DUNGEON_HEIGHT ];
        this.map = map;
        this.hero = hero;
        this.enemies = enemies;
        this.treasures = treasures;
    }

    public char[][] getMap() {
        return this.map;
    }


    public boolean fight(Enemy enemy) {
        while (hero.isAlive() && enemy.isAlive()) {
            enemy.takeDamage(hero.attack());
            hero.takeDamage(enemy.attack());
        }
        return hero.isAlive();
    }


    public String makeMove(int command) {

        if (command == LEFT || command == UP || command == RIGHT || command == DOWN) {

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
                        String message = treasures.pop().collect(hero);
                        changeMap(command);
                        hero.getPosition().ChangePosition(command);
                        return message;
                    case 'E':
                        if (!fight(enemies.pop())) {
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
            case LEFT:
                return map[hero.getPosition().getVP()][hero.getPosition().getHP() - UP];
            case UP:
                return map[hero.getPosition().getVP() - UP][hero.getPosition().getHP()];
            case 2:
                return map[hero.getPosition().getVP()][hero.getPosition().getHP() + UP];
        }

        return map[hero.getPosition().getVP() + UP][hero.getPosition().getHP()];
    }


    // changes the map by moving the hero to the desired position and marking his
    // previous position
    public void changeMap(int command) {

        switch (command) {
            case LEFT:
                map[hero.getPosition().getVP()][hero.getPosition().getHP() - UP] = 'H';
                break;
            case UP:
                map[hero.getPosition().getVP() - UP][hero.getPosition().getHP()] = 'H';
                break;
            case 2:
                map[hero.getPosition().getVP()][hero.getPosition().getHP() + UP] = 'H';
                break;
            case DOWN:
                map[hero.getPosition().getVP() + UP][hero.getPosition().getHP()] = 'H';
        }
        map[hero.getPosition().getVP()][hero.getPosition().getHP()] = '.';

    }

}
