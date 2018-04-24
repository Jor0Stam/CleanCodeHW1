package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell extends Defense implements Treasure {
	
	private int manaCost;
		
	public Spell(String name, int damage, int manaCost){
		super(name, damage);
		this.manaCost=manaCost;
	}
			
	public void setManaCost(int manaCost) {
		this.manaCost=manaCost;
	}
		
	public int getManaCost() {
		return this.manaCost;
	}
			
	public String collect(Hero hero) {
		hero.learn(this); 
		return "Spell found! Damage points: "+ super.getDamage() + ", Mana cost: "+ this.getManaCost();
	}
}
