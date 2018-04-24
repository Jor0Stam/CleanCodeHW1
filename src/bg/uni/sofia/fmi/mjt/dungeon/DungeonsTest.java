package bg.uni.sofia.fmi.mjt.dungeon;
import java.util.Scanner;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Enemy;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Position;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.HealthPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.ManaPotion;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Treasure;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class DungeonsTest {

	public static void main(String[] args) {
		char[][] exampleMap = {{'S','.', '#','#','.','.','.','.','.','T'},
							   {'#','T', '#','#','.','.','#','#','#','.'},
							   {'#','.', '#','#','#','E','#','#','#','E'},
							   {'#','.', 'E','.','.','.','#','#','#','.'},
							   {'#','#', '#','T','#','#','#','#','#','G'}};
		
		Weapon first = new Weapon("sword", 15);
		Weapon second = new Weapon("sword", 15);
		Weapon third = new Weapon("sword", 15);
		Weapon oathkeeper = new Weapon("sword", 25);
		
		Spell one = new Spell("fire", 10, 5);
		Spell two = new Spell("fire", 20, 20);
		Spell three = new Spell("fire", 20, 10);
		Spell four = new Spell("fire", 10, 5);
		
		HealthPotion blood = new HealthPotion(40);
		ManaPotion manaPotion = new ManaPotion(30);
		
		Enemy joffrey = new Enemy("joffrey",20,10,first,one);
		Enemy littlefinger = new Enemy("littlefinger",40,10,second,two);
		Enemy nightking = new Enemy("nightking",40,50,third,three);
		
		Position place = new Position(0,0);
		Hero johnsnow = new Hero("johnsnow", 100, 50, place);
		
		Treasure[] treasures = {four,blood, oathkeeper, manaPotion};
		Enemy[] enemies = {joffrey,littlefinger,nightking};
		
		GameEngine gameEngine = new GameEngine(exampleMap, johnsnow, enemies, treasures);
		
		Scanner input = new Scanner(System.in);
		int move;
		String result;
		do {
			move = input.nextInt();
			result = gameEngine.makeMove(move);
			System.out.println(result);
			//gameEngine.printMap();
		}while(result != "You have successfully passed through the dungeon. Congrats!" || 
			   result != "Hero is dead! Game over!");
		
		
		
			
	}

}
