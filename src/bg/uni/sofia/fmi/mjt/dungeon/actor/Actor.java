package bg.uni.sofia.fmi.mjt.dungeon.actor;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;

public interface Actor {
	
	String getName();
	int getHealth();
	int getMana();
	boolean isAlive();
	Weapon getWeapon();
	Spell getSpell();
	void takeDamage(int damagePoints);
	int attack();
	
}
