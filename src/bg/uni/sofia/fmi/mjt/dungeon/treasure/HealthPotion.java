package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion extends Potion implements Treasure {
			
	public HealthPotion(int healingPoints){
		super(healingPoints);
	}
			
	public String collect(Hero hero) {
		hero.takeHealing(this.heal());
		return "Health potion found! " + super.heal() + " health points added to your hero!";
	}
}
