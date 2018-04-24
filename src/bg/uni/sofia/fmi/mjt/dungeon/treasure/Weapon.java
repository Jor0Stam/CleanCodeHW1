package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon extends Defense implements Treasure{
	
	public Weapon(String name, int damage){
		super(name, damage);
	}
	
	public String collect(Hero hero) {
		hero.equip(this);
		return "Weapon found! Damage points: " + super.getDamage();
	}
}
