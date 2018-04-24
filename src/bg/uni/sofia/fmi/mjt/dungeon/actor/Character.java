package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public abstract class Character {
	private String name;
	private int health; 
	private int mana;
	private Weapon weapon;
	private Spell spell;
	
	public Character(){ 
		this.name="";
		this.health=0;
		this.mana=0;
	}
	
	public Character(String name, int health, int mana, Weapon weapon, Spell spell) {
		this.name=name;
		this.health=health;
		this.mana=mana;
		this.weapon=weapon;
		this.spell=spell;
	}
	
	public String getName() {
		return this.name;
	}
	public int getHealth() {
		return this.health;
	}
	public int getMana() {
		return this.mana;
	}
	public Weapon getWeapon() {
		return this.weapon;
	}
	public Spell getSpell() {
		return this.spell; 
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setMana(int mana) {
		this.mana=mana;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon=weapon;
	}
	public void setSpell(Spell spell) {
		this.spell=spell; 
	}
	
	
	public boolean isAlive() {
		return this.health > 0;
	}
	
	
	public void takeDamage(int damagePoints) {
		if(this.isAlive()) {
			health = (health - damagePoints) < 0 ? 0 : health - damagePoints;
		}
	}	
		
	public int attack() {
		if(spell!=null && weapon!=null && isAlive()) {
			if(spell.getManaCost()<=this.mana && spell.getDamage() > weapon.getDamage()) {
				this.mana-=this.spell.getManaCost();
				return spell.getDamage();
			}
				return weapon.getDamage();
		}
		
		if(spell != null && isAlive()) {
			if(spell.getManaCost()<=this.mana) {
				this.mana-=this.spell.getManaCost();
				return spell.getDamage();
			}
		}
		
		if(this.weapon != null && isAlive()) {
			return weapon.getDamage();
		}
		
		return 0;
	}
}
