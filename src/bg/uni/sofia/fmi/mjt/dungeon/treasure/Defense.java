package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public abstract class Defense {
	private String name;
	private int damage;
	
	
	public Defense(String name, int damage){
		this.name=name;
		this.damage=damage;
		
	}
	
	public void setNeme(String name) {
		this.name=name;
	}
	
	public void setDmage(int damage) {
		this.damage=damage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damage;
	}
		
	abstract String collect(Hero hero);
}
