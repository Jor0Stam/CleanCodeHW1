package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public abstract class Potion{
	private int healingPoints;
	
	public Potion(int healingPoints){
		this.healingPoints=healingPoints;
	}
	
	public void setHealingPoints(int healingPoints) {
		this.healingPoints=healingPoints;
	}
	
	public int heal() {
		return this.healingPoints;
	}
	
	abstract String collect(Hero hero);
		
		
}
