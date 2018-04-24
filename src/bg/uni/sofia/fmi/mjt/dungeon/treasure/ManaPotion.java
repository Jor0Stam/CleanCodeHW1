package bg.uni.sofia.fmi.mjt.dungeon.treasure;
import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion extends Potion implements Treasure{
		
	public ManaPotion(int manaPoints){
		super(manaPoints);
	}
			
	public String collect(Hero hero) {
		hero.takeMana(heal());
		return "Mana potion found! " + super.heal() + " mana points added to your hero!";
	}
}
