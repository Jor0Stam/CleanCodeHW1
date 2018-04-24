package bg.uni.sofia.fmi.mjt.dungeon.actor;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;

public class Hero extends Character implements Actor{
	
	private int maxHealth;
	private int maxMana;
	private Position position;
	
	public Hero() {
		super();
	}
	public Hero(String name, int health, int mana, Position position) {
		super(name, health, mana, null, null);
		this.maxHealth=health;
		this.maxMana=mana;
		this.position=position;
	}
	
	
	public Position getPosition() {
		return this.position;
	}
		
	public void takeHealing(int healingPoints) {
		if(this.isAlive()) {
			int health = (super.getHealth() + healingPoints) < maxHealth ? super.getHealth() + healingPoints : maxHealth;
			super.setHealth(health);
		}
	}
	
	public void takeMana(int manaPoints) {
		if(this.isAlive()) {
			int mana = (super.getMana() + manaPoints) < maxMana ? super.getMana() + manaPoints : maxMana;
			super.setMana(mana);
		}
	}
		
	public void equip(Weapon newWeapon) {
		if(newWeapon!= null && (super.getWeapon()==null || newWeapon.getDamage()>super.getWeapon().getDamage())) {
			super.setWeapon(newWeapon);
		}
	}
	
	public void learn(Spell newSp){
		if(newSp!= null && (super.getSpell()==null || newSp.getDamage()>super.getSpell().getDamage())) {
			super.setSpell(newSp);
		}
	}
	
	
}
